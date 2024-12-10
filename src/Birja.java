public class Birja {
        private String profession;
        private String education; //образование
        private String lastposition; //прошлое место и должность
        private String cause; //причина увольнения
        private String family;
        private String home;
        private String contacts;
        private String requirements; //требования
        private String work; //работа;

        public Birja(String profession, String education, String lastposition, String cause, String family, String home,String contacts,String requirements,String work) {
            this.profession = profession;
            this.education = education;
            this.lastposition = lastposition;
            this.cause = cause;
            this.family = family;
            this.home = home;
            this.contacts = contacts;
            this.requirements = requirements;
            this.work = work;
        }


        public String getProfession() {

            return profession;
        }

        public void setProfession(String profession) {

            this.profession = profession;
        }

        public String getLastposition() {

            return lastposition;
        }

        public void setLastposition(String lastposition) {
            this.lastposition = lastposition;
        }

        public String getCause() {
            return cause;
        }

        public void setCause(String cause) {
            this.cause = cause;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getRequirements() {
            return requirements;
        }

        public void setRequirements(String requirements) {
            this.requirements = requirements;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }
        public String getWork() {
            return work;
        }
        public void setWork(String work) {
            this.work = work;
        }


}
