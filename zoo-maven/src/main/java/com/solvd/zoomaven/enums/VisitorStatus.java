package com.solvd.zoomaven.enums;

public enum VisitorStatus {
        GENERAL(false),
        STUDENT(false),
        VIP(true),
        CHILD(false);
        private final boolean hasPrivileges;

        VisitorStatus(boolean hasPrivileges) {
                this.hasPrivileges = hasPrivileges;
        }

        public boolean isHasPrivileges() {
                return hasPrivileges;
        }
}
