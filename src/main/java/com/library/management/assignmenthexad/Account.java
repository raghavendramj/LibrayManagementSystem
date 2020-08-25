package com.library.management.assignmenthexad;

public class Account {

    private int userId;
    private String password;
    private String accountId;

    public Account(int userId, String password, String accountId) {
        this.userId = userId;
        this.password = password;
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (getUserId() != account.getUserId()) return false;
        if (getPassword() != null ? !getPassword().equals(account.getPassword()) : account.getPassword() != null)
            return false;
        return getAccountId() != null ? getAccountId().equals(account.getAccountId()) : account.getAccountId() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserId();
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getAccountId() != null ? getAccountId().hashCode() : 0);
        return result;
    }
}
