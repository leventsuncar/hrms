package com.hrms.core.utilities.apiPath;
//Bu classın core katmanında olması ne kadar doğru bilmiyorum.
public final class ApiPaths {

    private static final String BASE_PATH = "/api";

    public static final class EmployersCtrl {
        public static final String CTRL = BASE_PATH + "/employers";
    }

    public static final class JobPositionsCtrl {
        public static final String CTRL = BASE_PATH + "/jobpositions";
    }

    public static final class JobSeekersCtrl {
        public static final String CTRL = BASE_PATH + "/jobseekers";
    }

    public static final class SystemStaffsCtrl {
        public static final String CTRL = BASE_PATH + "/systemstaffs";
    }
}
