package com.hfab.desalesmessanger;

public class Conversation {

        private int id;
        private int student1ID;
        private int student2ID;
        private int imageID;
        private String timestamp;
        private String lastMessageSent;

        public Conversation(int id, int student1ID, int student2ID, int imageID, String timestamp, String lastMessageSent)
        {
            this.id = id;
            this.student1ID = student1ID;
            this.student2ID = student2ID;
            this.imageID = imageID;
            this.timestamp = timestamp;
            this.lastMessageSent = lastMessageSent;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStudent1ID() {
            return student1ID;
        }

        public void setStudent1ID(int student1ID) {
            this.student1ID = student1ID;
        }

        public int getStudent2ID() {
            return student2ID;
        }

        public void setStudent2ID(int student2ID) {
            this.student2ID = student2ID;
        }

        public int getImageID() {
            return imageID;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getLastMessageSent() {
            return lastMessageSent;
        }

        public void setLastMessageSent(String lastMessageSent) {
            this.lastMessageSent = lastMessageSent;
        }

        @Override
        public String toString() {
            return "Conversation{" +
                    "id=" + id +
                    ", student1ID=" + student1ID +
                    ", student2ID=" + student2ID +
                    ", imageID=" + imageID +
                    ", timestamp='" + timestamp + '\'' +
                    ", lastMessageSent='" + lastMessageSent + '\'' +
                    '}';
        }
}
