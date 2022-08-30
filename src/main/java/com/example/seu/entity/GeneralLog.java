package com.example.seu.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.Data;

/**
 * General log
 * @TableName general_log
 */
@Data
public class GeneralLog implements Serializable {
    /**
     * 
     */
    private LocalDateTime eventTime;

    /**
     * 
     */
    private String userHost;

    /**
     * 
     */
    private Long threadId;

    /**
     * 
     */
    private Object serverId;

    /**
     * 
     */
    private String commandType;

    /**
     * 
     */
    private byte[] argument;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GeneralLog other = (GeneralLog) that;
        return (this.getEventTime() == null ? other.getEventTime() == null : this.getEventTime().equals(other.getEventTime()))
            && (this.getUserHost() == null ? other.getUserHost() == null : this.getUserHost().equals(other.getUserHost()))
            && (this.getThreadId() == null ? other.getThreadId() == null : this.getThreadId().equals(other.getThreadId()))
            && (this.getServerId() == null ? other.getServerId() == null : this.getServerId().equals(other.getServerId()))
            && (this.getCommandType() == null ? other.getCommandType() == null : this.getCommandType().equals(other.getCommandType()))
            && (Arrays.equals(this.getArgument(), other.getArgument()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEventTime() == null) ? 0 : getEventTime().hashCode());
        result = prime * result + ((getUserHost() == null) ? 0 : getUserHost().hashCode());
        result = prime * result + ((getThreadId() == null) ? 0 : getThreadId().hashCode());
        result = prime * result + ((getServerId() == null) ? 0 : getServerId().hashCode());
        result = prime * result + ((getCommandType() == null) ? 0 : getCommandType().hashCode());
        result = prime * result + (Arrays.hashCode(getArgument()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventTime=").append(eventTime);
        sb.append(", userHost=").append(userHost);
        sb.append(", threadId=").append(threadId);
        sb.append(", serverId=").append(serverId);
        sb.append(", commandType=").append(commandType);
        sb.append(", argument=").append(argument);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}