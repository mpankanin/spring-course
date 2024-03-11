package com.qaracter.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Status {

    @NotNull
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String statusName;

    public Status() {    }

    public Status(Integer id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public Integer getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    private void setStatusName(String statusName) {
        this.statusName = statusName;
    }


}
