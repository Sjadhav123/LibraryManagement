package com.silicus.librarymanagment.entity;

import java.io.Serializable;

public class BookIssueTracker implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int bid;
	private User user;
	private String dateOfIssue;
	private String expDate;
	private String issuer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid;
		result = prime * result + ((dateOfIssue == null) ? 0 : dateOfIssue.hashCode());
		result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookIssueTracker other = (BookIssueTracker) obj;
		if (bid != other.bid)
			return false;
		if (dateOfIssue == null) {
			if (other.dateOfIssue != null)
				return false;
		} else if (!dateOfIssue.equals(other.dateOfIssue))
			return false;
		if (expDate == null) {
			if (other.expDate != null)
				return false;
		} else if (!expDate.equals(other.expDate))
			return false;
		if (id != other.id)
			return false;
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		} else if (!issuer.equals(other.issuer))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookIssueTracker [id=" + id + ", bid=" + bid + ", user=" + user + ", dateOfIssue=" + dateOfIssue
				+ ", expDate=" + expDate + ", issuer=" + issuer + "]";
	}
	
}
