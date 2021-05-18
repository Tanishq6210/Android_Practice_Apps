package com.example.android.quakereport;

    public class Earthquake {
        private double magnitude;
        private String place;
        private Long time;
        private String url;

        public String getUrl() {
            return url;
        }

        /**
         *
         * @param mag
         * @param place
         * @param time
         */
        public Earthquake(double mag, String place, Long time, String url){
            this.magnitude = mag;
            this.place = place;
            this.time = time;
            this.url = url;
        }

        /**
         *
         * @return
         */
        public Long getTime() {
            return time;
        }

        /**
         *
         * @return
         */
        public String getPlace() {
            return place;
        }

        public double getMagnitude() {
            return magnitude;
        }

    }


