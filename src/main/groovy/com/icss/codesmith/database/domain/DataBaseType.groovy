package com.icss.codesmith.database.domain

/**
 * Created by XizeTian on 2016/12/30.
 */
enum DataBaseType {
    MYSQL( 0, 'MYSQL', 'com.mysql.jdbc.Driver' ),
    SQLSERVER( 1, 'SQLSERVER', 'com.microsoft.sqlserver.jdbc.SQLServerDriver' )

    int    type = 0
    String name
    String driver

    DataBaseType( int type, String name, String driver ) {
        this.type = type
        this.name = name
        this.driver = driver
    }

    String getUrl( String ip, int port ) {
        String url
        switch ( type ) {
            case 0:
                url = "jdbc:mysql://${ ip }:${ port }/information_schema?characterEncoding=utf-8"
                break
            case 1:
                url = "jdbc:sqlserver://${ ip }:${ port }; DatabaseName=information_schema"
                break
        }
        return url
    }
}
