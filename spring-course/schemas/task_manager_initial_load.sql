-- inserting 'roles'
INSERT INTO roles (RoleName, Description) VALUES ('Administrator', 'Admin role with all privileges');
INSERT INTO roles (RoleName, Description) VALUES ('User', 'Standard user role');
INSERT INTO roles (RoleName, Description) VALUES ('Guest', 'Guest user with limited privileges');

-- inserting 'statuses'
INSERT INTO statuses (StatusName) VALUES ('Open');
INSERT INTO statuses (StatusName) VALUES ('In Progress');
INSERT INTO statuses (StatusName) VALUES ('Closed');

-- inserting 'users'
INSERT INTO users (Username, Password, RoleID) VALUES ('john_doe', '123', 2);
INSERT INTO users (Username, Password, RoleID) VALUES ('jane_smith', '456', 1);
INSERT INTO users (Username, Password, Email, RoleID) VALUES ('guest_user', '321', 'myemail@email.com', 3);

-- inserting 'tasks'
INSERT INTO tasks (Title, Description, StatusID, UserID) VALUES ('Complete Database Setup', 'Set up the initial database schema', 1, 1);
INSERT INTO tasks (Title, Description, StatusID) VALUES ('Implement Authentication System', 'Develop and integrate an authentication system', 2);

-- inserting 'grants'
INSERT INTO grants (GrantName, Description) VALUES ('View Tasks', 'Permission to view tasks');
INSERT INTO grants (GrantName, Description) VALUES ('Edit Tasks', 'Permission to edit tasks');
INSERT INTO grants (GrantName, Description) VALUES ('Delete Tasks', 'Permission to delete tasks');

-- inserting 'assigned_grants_to_role'
INSERT INTO assigned_grants_to_role (RoleID, GrantID) VALUES (1, 2);
INSERT INTO assigned_grants_to_role (RoleID, GrantID) VALUES (2, 3);
INSERT INTO assigned_grants_to_role (RoleID, GrantID) VALUES (3, 1);


