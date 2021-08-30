package com.nasr.hospital.db.type;

/**
 *
 * @author Muhamed S. NasR 
 * Constants in the Application....
 * 
 */
public enum UsersType {

    ADMIN(1, "Admin"), DOCTOR(2, "Doctor");
    
    private int id;
    private String type;

    private UsersType(int id, String Type) {

        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static UsersType getUserTypeById(int id) {

        for (UsersType usersType : UsersType.values()) {
            if (usersType.getId() == id) {

                return usersType;
            }
            return null;

        }
        return null;


    }
}
