package org.pivotal.support;

public final class MessageManager {


    public static Message createdSuccessfully(String entity) {
        String message = String.format("The %s was created", entity);
        return new Message("201", message);
    }

    public static Message updatedSuccessfully(String entity) {
        String message = String.format("The %s was updated", entity);
        return new Message("202", message);
    }

    public static Message deletedSuccessfully(String entity) {
        String message = String.format("The %s was deleted", entity);
        return new Message("200", message);
    }

    public static Message entityDoesNotExist(String entity) {
        String message = String.format("The %s doesn't exist", entity);
        return new Message("404", message);
    }
}
