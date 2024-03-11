package com.qaracter.entities;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer TaskID;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "dueDate")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "statusID", nullable = false)
    private StatusEntity statusEntity;

    //@ManyToOne
    //@JoinColumn(name = "user")
    //private UserEntity userEntity;


        public TaskEntity() {
        }

        public TaskEntity(int id, String title, String description, Date dueDate, StatusEntity statusEntity, UserEntity userEntity) {
            this.TaskID = id;
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.statusEntity = statusEntity;
            //this.userEntity = userEntity;
        }

        public Integer getId() {
            return TaskID;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public Date getDueDate() {
            return dueDate;
        }

        public StatusEntity getStatusEntity() {
            return statusEntity;
        }

        //public UserEntity getUserEntity() {
            //return userEntity;
        //}







}
