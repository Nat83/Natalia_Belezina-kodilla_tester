public class Grades {
    public int[] grades;
    private int size;

    public Grades() {
        this.grades = new int[10];
        this.size = 0;
    }
    public void add(int value) {
        if (this.size == 10) {
            return;
        }
        this.grades[this.size] = value;
        this.size++;
    }
    public int returnLastAddedGrade() {
        if (this.size > 0) {
            return this.grades[this.size - 1];
        } else {
            return 0;
        }
    }

        public double returnAverageGrade () {
            double sumOfGrades = 0;

            for (int i = 0; i < this.size; i++) {
                int grade = this.grades[i];
                sumOfGrades = sumOfGrades + grade;
            }
            return sumOfGrades / this.size;
        }
    }
