package org.trump.vincent.defaults.mappings;

/**
 * Created by Vincent on 2017/8/30 0030.
 */
/**
 * Construct default mapping of type, from Oracle or MySQL
 */
public class MSSQLType {

    public static String from(String typeName,String driverType){
        if("oracle".equalsIgnoreCase(driverType)){
            return MSSQLType.FromOracle.type(typeName);
        }else if("mysql".equalsIgnoreCase(driverType)){
            return MSSQLType.FromMySQL.type(typeName);
        }else {
            throw new RuntimeException("Warn: Sorry, None Mappings for " + driverType);
        }
    }



    enum FromOracle{
        BFILE("BFILE","VARBINARY"),

        //TODO  please do settings in accordance with OFFICIAL REFERENCE

        ;

        FromOracle(String oracleTypeName, String mssqlTypeName) {
            this.mssqlTypeName = mssqlTypeName;
            this.oracleTypeName = oracleTypeName;
        }

        public static String type(String oracleTypeName){
            FromOracle[] types = FromOracle.values();
            if(types!=null&& types.length>0){
                for(FromOracle type :types){
                    if(type.getOracleTypeName().equalsIgnoreCase(oracleTypeName)){
                        return type.getMssqlTypeName();
                    }
                }
            }
            return null;
        }


        private String oracleTypeName;
        private String mssqlTypeName;


        public String getOracleTypeName() {
            return oracleTypeName;
        }

        public void setOracleTypeName(String oracleTypeName) {
            this.oracleTypeName = oracleTypeName;
        }

        public String getMssqlTypeName() {
            return mssqlTypeName;
        }

        public void setMssqlTypeName(String mssqlTypeName) {
            this.mssqlTypeName = mssqlTypeName;
        }

    }

    /**
     * refer to @
     * https://technet.microsoft.com/library/Cc966396
     */
    enum FromMySQL{
        //Numeric types
        TINYINT("TINYINT","TINYINT"),
        SMALLINT("SMALLINT","SMALLINT"),
        MEDIUMINT("MEDIUMINT","INT"),
        INT("INT","INT"),
        INTEGER("INTEGER","INT"),
        BIGINT("BIGINT","BIGINT"),
        FLOAT("FLOAT","FLOAT"),
        DOUBLE("DOUBLE","FLOAT"),
        DOUBLE_PRECISION("DOUBLE PRECISION","FLOAT"),
        REAL("REAL","REAL"),
        DECIMAL("DECIMAL","DECIMAL"),
        NUMERIC("NUMERIC","NUMERIC"),

        //Date and Time
        DATE("DATE","SMALLDATETIME"),
        DATETIME("DATETIME","DATETIME"),
        TIMESTAMP("TIMESTAMP","TIMESTAMP"),
        TIME("TIME","SMALLDATETIME"),
        YEAR("YEAR","SMALLDATETIME"),

        //String Types
        CHAR("CHAR","CHAR"),
        VARCHAR("VARCHAR","VARCHAR"),
        TINYBLOB("TINYBLOB","BINARY"),
        BLOB("BLOB","VARBINARY"),
        TEXT("TEXT","TEXT"),
        MEDIUMBLOB("MEDIUMBLOB","IMAGE"),
        MEDIUMTEXT("MEDIUMTEXT","TEXT"),
        LONGBLOB("LONGBLOB","IMAGE"),
        LONGTEXT("LONGTEXT","TEXT"),
        ;

        FromMySQL(String mysqlTypeName, String mssqlTypeName) {
            this.mysqlTypeName = mysqlTypeName;
            this.mssqlTypeName = mssqlTypeName;
        }

        public static String type(String mysqlTypeName){
            FromMySQL[] types = FromMySQL.values();
            if(types!=null&& types.length>0){
                for(FromMySQL type :types){
                    if(type.getMssqlTypeName().equalsIgnoreCase(mysqlTypeName)){
                        return type.getMssqlTypeName();
                    }
                }
            }
            return null;
        }

        private String mysqlTypeName;
        private String mssqlTypeName;

        public String getMysqlTypeName() {
            return mysqlTypeName;
        }

        public void setMysqlTypeName(String mysqlTypeName) {
            this.mysqlTypeName = mysqlTypeName;
        }

        public String getMssqlTypeName() {
            return mssqlTypeName;
        }

        public void setMssqlTypeName(String mssqlTypeName) {
            this.mssqlTypeName = mssqlTypeName;
        }

    }


}
