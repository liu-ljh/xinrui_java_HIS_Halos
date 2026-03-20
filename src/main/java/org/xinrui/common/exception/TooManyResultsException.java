package org.xinrui.common.exception;

import lombok.Getter;

/**
 * 自定义查询多条数据异常
 * 用于在 selectOne 查询到多条数据时，提供更详细的错误信息（表名、查询字段）
 */
@Getter
public class TooManyResultsException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "查询返回多条数据";

    /**
     * 表名
     */
    private final String tableName;

    /**
     * 查询条件字段名
     */
    private final String fieldName;

    public TooManyResultsException(String tableName, String fieldName) {
        super(String.format("表[%s]利用字段[%s]进行单一查询时返回了多条数据", tableName, fieldName));
        this.tableName = tableName;
        this.fieldName = fieldName;
    }

    public TooManyResultsException(String message) {
        super(message);
        this.tableName = "未知表";
        this.fieldName = "未知字段";
    }
}
