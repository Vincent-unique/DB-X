package org.trump.vincent.defaults.mappings;

/**
 * Created by Vincent on 2017/8/30 0030.
 */

/**
 * Construct default mapping of type, from Oracle or  Microsoft SqlServer
 */
public class MySQLType {

    public static String from(String typeName,String driverType){
        if("sqlserver".equalsIgnoreCase(driverType)){
            return MySQLType.FromMSSQL.type(typeName);
        }else if("oracle".equalsIgnoreCase(driverType)){
            return MySQLType.FromOracle.type(typeName);
        }else {
            throw new RuntimeException("Warn: Sorry, None Mappings for " + driverType);
        }
    }

    enum FromMSSQL{

        //TODO  please do settings in accordance with OFFICIAL REFERENCE

        ;
        public static String type(String MSSQLType) {
            FromMSSQL[] types = FromMSSQL.values();
            if (types != null && types.length > 0) {
                for (FromMSSQL type : types) {
                    if (type.getMSSQLType().equalsIgnoreCase(MSSQLType)) {
                        return type.getOracleType();
                    }
                }
            }
            return null;
        }

        FromMSSQL(String MSSQLType, String oracleType) {
            this.MSSQLType = MSSQLType;
            OracleType = oracleType;
        }

        private String MSSQLType;
        private String OracleType;

        public String getMSSQLType() {
            return MSSQLType;
        }

        public void setMSSQLType(String MSSQLType) {
            this.MSSQLType = MSSQLType;
        }

        public String getOracleType() {
            return OracleType;
        }

        public void setOracleType(String oracleType) {
            OracleType = oracleType;
        }

    }

    enum FromOracle{

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
}
