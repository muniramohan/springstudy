package com.bnp.showroom.common;

public class QueryConstants {
    public QueryConstants() {
    }

    public static final String FIND_BY_EMAIL = "SELECT * FROM USER_PROFILES WHERE PROFILE_ENABLED = 'TRUE' AND email= ?1";
    public static final String FIND_BY_EMAIL_ONLY="SELECT * FROM USER_PROFILES WHERE email= ?1";
    public static final String VERIFY_EMAIL_TOKEN="SELECT * FROM USER_PROFILES WHERE VERIFICATION_TOKEN= ?1";
    public static final String VERIFICATION_TOKEN="SELECT VERIFICATION_TOKEN FROM USER_PROFILES WHERE EMAIL= ?1";
}
