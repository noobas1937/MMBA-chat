/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

/**
 *
 * @author bassem
 */
public interface IUser extends Serializable, Remote {

    Boolean add() throws RemoteException;

    Boolean addContact(String contactEmail) throws RemoteException;

    void addSession(ISession s) throws RemoteException;

    Boolean changeStatus(String status) throws RemoteException;

    User completeInfo() throws RemoteException;

    public void connect(Registry r) throws RemoteException;
    
    User findUser(String searchEmail) throws RemoteException;

    List<User> getContactList() throws RemoteException;

    String getEmail() throws RemoteException;

    String getGender() throws RemoteException;

    String getPassword() throws RemoteException;

    String getStatus()throws RemoteException;

    String getUsername() throws RemoteException;

    
    Boolean isContact(String contactEmail) throws RemoteException;

    Boolean isExist(String searchEmail) throws RemoteException;

    Boolean login() throws RemoteException;

    void logout() throws RemoteException;

    public void recieveMessage(ISession s, IMessage msg) throws RemoteException;

    void sendMessage(String text, ISession s) throws RemoteException;

    void setStatus(String status) throws RemoteException;
    void setGui(IChatClient gui) throws RemoteException;
    public int getSessionId(int chatFrameId) throws RemoteException;
    public void createChatFrame(List<String> mailList, int newSession) throws RemoteException;


    public void sendNotifecation(String string) throws RemoteException;

    public void recieveData(String name, byte[] myData, int buffer) throws RemoteException;

    public void getNotified(String text) throws RemoteException;
}
