public class Course {
    private String courseName;
    private Student[] roster;
    private Student[] waitlist;
    private int maxRosterSize;
    private int maxWaitlistSize;
    private int rosterSize;
    private int waitlistSize;

    public Course(String courseName, int maxRosterSize, int maxWaitlistSize) {
        this.courseName = courseName;
        this.roster = new Student[maxRosterSize];
        this.waitlist = new Student[maxWaitlistSize];
        this.maxRosterSize = maxRosterSize;
        this.maxWaitlistSize = maxWaitlistSize;
        this.rosterSize = 0;
        this.waitlistSize = 0;
    }

    // Getters and setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getMaxRosterSize() {
        return maxRosterSize;
    }

    public int getMaxWaitlistSize() {
        return maxWaitlistSize;
    }

    public int getRosterSize() {
        return rosterSize;
    }

    public int getWaitlistSize() {
        return waitlistSize;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(courseName).append("\n");
        sb.append(rosterSize).append(" enrolled (maximum allowed ").append(maxRosterSize).append(")\n");
        for (int i = 0; i < rosterSize; i++) {
            if (roster[i] != null) {
                sb.append(roster[i]).append("\n");
            }
        }
        sb.append(waitlistSize).append(" on waitlist (maximum allowed ").append(maxWaitlistSize).append("):\n");
        for (int i = 0; i < waitlistSize; i++) {
            if (waitlist[i] != null) {
                sb.append(waitlist[i]).append("\n");
            }
        }
        return sb.toString();
    }

    // addStudent method
    public boolean addStudent(Student student) {
        if (student == null || !student.isTuitionPaid()) {
            return false;
        }

        if (isEnrolled(student) || isWaitlisted(student)) {
            return false;
        }

        if (rosterSize < maxRosterSize) {
            roster[rosterSize] = student;
            rosterSize++;
            return true;
        } else if (waitlistSize < maxWaitlistSize) {
            waitlist[waitlistSize] = student;
            waitlistSize++;
            return true;
        } else {
            return false;
        }
    }

    // dropStudent method
    public boolean dropStudent(Student student) {
        if (student == null) {
            return false;
        }

        int index = findStudentIndex(student);

        if (index == -1) {
            return false;
        }

        if (index < rosterSize) {
            removeStudentFromRoster(index);
            if (waitlistSize > 0) {
                addStudentFromWaitlistToRoster();
            }
        } else if (index < rosterSize + waitlistSize) {
            removeStudentFromWaitlist(index - rosterSize);
        }

        return true;
    }

    // Helper method to check if a student is already on the roster
    private boolean isEnrolled(Student student) {
        for (int i = 0; i < rosterSize; i++) {
            if (roster[i] != null && roster[i].equals(student)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to check if a student is already on the waitlist
    private boolean isWaitlisted(Student student) {
        for (int i = 0; i < waitlistSize; i++) {
            if (waitlist[i] != null && waitlist[i].equals(student)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to find the index of a student in the roster or waitlist
    private int findStudentIndex(Student student) {
        for (int i = 0; i < rosterSize; i++) {
            if (roster[i] != null && roster[i].equals(student)) {
                return i;
            }
        }
        for (int i = 0; i < waitlistSize; i++) {
            if (waitlist[i] != null && waitlist[i].equals(student)) {
                return i + rosterSize;
            }
        }
        return -1;
    }

    // Helper method to remove a student from the roster
    private void removeStudentFromRoster(int index) {
        for (int i = index; i < rosterSize - 1; i++) {
            roster[i] = roster[i + 1];
        }
        roster[rosterSize - 1] = null;
        rosterSize--;
    }

    // Helper method to remove a student from the waitlist
    private void removeStudentFromWaitlist(int index) {
        for (int i = index; i < waitlistSize - 1; i++) {
            waitlist[i] = waitlist[i + 1];
        }
        waitlist[waitlistSize - 1] = null;
        waitlistSize--;
    }

    // Helper method to add a student from the waitlist to the roster
    private void addStudentFromWaitlistToRoster() {
        roster[rosterSize] = waitlist[0];
        rosterSize++;
        removeStudentFromWaitlist(0);
    }
}
