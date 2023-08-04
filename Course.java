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

    public void setMaxRosterSize(int rosterSize) {
        this.maxRosterSize = rosterSize;
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

    public boolean addStudent(Student student) {
        if (student == null || !student.isTuitionPaid()) {
            return false;
        }

        if (isEnrolled(student)) {
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

    // HELPER METHODS
    private boolean isEnrolled(Student student) {
        for (int i = 0; i < rosterSize; i++) {
            if (roster[i] != null && roster[i].equals(student)) {
                return true;
            }
        }
        for (int i = 0; i < waitlistSize; i++) {
            if (waitlist[i] != null && waitlist[i].equals(student)) {
                return true;
            }
        }
        return false;
    }

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

    private void removeStudentFromRoster(int index) {
        for (int i = index; i < rosterSize - 1; i++) {
            roster[i] = roster[i + 1];
        }
        roster[rosterSize - 1] = null;
        rosterSize--;
    }

    private void removeStudentFromWaitlist(int index) {
        for (int i = index; i < waitlistSize - 1; i++) {
            waitlist[i] = waitlist[i + 1];
        }
        waitlist[waitlistSize - 1] = null;
        waitlistSize--;
    }

    private void addStudentFromWaitlistToRoster() {
        roster[rosterSize] = waitlist[0];
        rosterSize++;
        removeStudentFromWaitlist(0);
    }
    
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
}
