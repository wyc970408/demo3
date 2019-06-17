package com.example.demo.quartz;

import javafx.util.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "JOB_ENTITY")
public class JobEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;            //job名称
    private String group;           //job组名
    private String cron;            //执行的cron
    private String parameter;       //job的参数
    private String description;     //job描述信息
    @Column(name = "vm_param")
    private String vmParam;         //vm参数
    @Column(name = "jar_path")
    private String jarPath;         //job的jar路径
    private String status;          //job的执行状态 open/close

    public JobEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVmParam() {
        return vmParam;
    }

    public void setVmParam(String vmParam) {
        this.vmParam = vmParam;
    }

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "JobEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", cron='" + cron + '\'' +
                ", parameter='" + parameter + '\'' +
                ", description='" + description + '\'' +
                ", vmParam='" + vmParam + '\'' +
                ", jarPath='" + jarPath + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public JobEntity(Builder builder) {

    }

    public static class Builder {
        private Integer id;
        private String name = "";
        private String group = "";
        private String cron = "";
        private String parameter = "";
        private String description = "";
        private String vmParam = "";
        private String jarPath = "";
        private String status = "";

        public Builder withId(Integer i) {
            id = i;
            return this;
        }

        public Builder withName(String n) {
            name = n;
            return this;
        }

        public Builder withGroup(String g) {
            group = g;
            return this;
        }

        public Builder withCron(String c) {
            cron = c;
            return this;
        }

        public Builder withParameter(String p) {
            parameter = p;
            return this;
        }

        public Builder withDescription(String d) {
            description = d;
            return this;
        }

        public Builder withVMParameter(String vm) {
            vmParam = vm;
            return this;
        }

        public Builder withJarPath(String jar) {
            jarPath = jar;
            return this;
        }

        public Builder withStatus(String s) {
            status = s;
            return this;
        }

        public JobEntity newJobEntity() {
            return new JobEntity(this);
        }


    }

}
