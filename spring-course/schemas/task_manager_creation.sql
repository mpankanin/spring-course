CREATE DATABASE IF NOT EXISTS TaskManager;
USE TaskManager;

-- Create table 'roles'
CREATE TABLE roles (
    RoleID INT PRIMARY KEY AUTO_INCREMENT,
    RoleName VARCHAR(50) UNIQUE NOT NULL,
    Description VARCHAR(255)
);

-- Create table 'statuses'
CREATE TABLE statuses (
    StatusID INT PRIMARY KEY AUTO_INCREMENT,
    StatusName VARCHAR(50) UNIQUE NOT NULL
);

-- Create table 'users'
CREATE TABLE users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(50) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    LastLogin DATE,
    RoleID INT NOT NULL,
    FOREIGN KEY (RoleID) REFERENCES roles(RoleID)
);

-- Create table 'tasks'
CREATE TABLE tasks (
    TaskID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Description VARCHAR(255),
    DueDate DATE,
    StatusID INT NOT NULL,
    UserID INT,
    FOREIGN KEY (StatusID) REFERENCES statuses(StatusID),
    FOREIGN KEY (UserID) REFERENCES users(UserID)
);

-- Create table 'grants'
CREATE TABLE grants (
    GrantID INT PRIMARY KEY AUTO_INCREMENT,
    GrantName VARCHAR(50) UNIQUE NOT NULL,
    Description VARCHAR(255)
);

-- Create table 'assigned_grants_to_role'
CREATE TABLE assigned_grants_to_role (
    AssignedID INT PRIMARY KEY AUTO_INCREMENT,
    RoleID INT NOT NULL,
    GrantID INT NOT NULL,
    FOREIGN KEY (RoleID) REFERENCES roles(RoleID),
    FOREIGN KEY (GrantID) REFERENCES grants(GrantID)
);
