package com.github.avaya2223.issuelist.domain;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Issue {
	private final IssueId issueId;
	private final String title;
	private final String description; 
	private final Status status;
	private final Priority priority;
	private final Date creationDate;
	private final IssueType type;
	
	public Issue(IssueId issueId, String title, String description, Status status, Priority priority, Date creationDate, IssueType type) {
		final String titleCln = StringUtils.trimToNull(title);
		final String descriptionCln = StringUtils.trimToNull(description);
		if (issueId == null) {
			throw new IllegalArgumentException("Argument 'issueId' should not be null.");
		}
		if (titleCln == null) {
			throw new IllegalArgumentException("Argument 'title' should not be null.");
		}
		if (descriptionCln == null) {
			throw new IllegalArgumentException("Argument 'description' should not be null.");
		}
		if (status == null) {
			throw new IllegalArgumentException("Argument 'status' should not be null.");
		}
		if (priority == null) {
			throw new IllegalArgumentException("Argument 'priority' should not be null.");
		}
		if (creationDate == null) {
			throw new IllegalArgumentException("Argument 'creationDate' should not be null.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Argument 'type' should not be null.");
		}
				
		this.issueId = issueId;
		this.title = titleCln;
		this.description = descriptionCln;
		this.status = status;
		this.priority = priority;
		this.creationDate = creationDate;
		this.type = type;
	}

	public Issue(IssueBuilder bldr) {
		final String titleCln = StringUtils.trimToNull(bldr.getTitle());
		final String descriptionCln = StringUtils.trimToNull(bldr.getDescription());
		if (bldr.getIssueId() == null) {
			throw new IllegalArgumentException("Argument 'issueId' should not be null.");
		}
		if (titleCln == null) {
			throw new IllegalArgumentException("Argument 'title' should not be null.");
		}
		if (descriptionCln == null) {
			throw new IllegalArgumentException("Argument 'description' should not be null.");
		}
		if (bldr.getStatus() == null) {
			throw new IllegalArgumentException("Argument 'status' should not be null.");
		}
		if (bldr.getPriority() == null) {
			throw new IllegalArgumentException("Argument 'priority' should not be null.");
		}
		if (bldr.getCreationDate() == null) {
			throw new IllegalArgumentException("Argument 'creationDate' should not be null.");
		}
		if (bldr.getType() == null) {
			throw new IllegalArgumentException("Argument 'type' should not be null.");
		}
				
		this.issueId = bldr.getIssueId();
		this.title = titleCln;
		this.description = descriptionCln;
		this.status = bldr.getStatus();
		this.priority = bldr.getPriority();
		this.creationDate = bldr.getCreationDate();
		this.type = bldr.getType();
	}

	public IssueId getIssueId() {
		return issueId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Status getStatus() {
		return status;
	}

	public Priority getPriority() {
		return priority;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public IssueType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((issueId == null) ? 0 : issueId.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Issue other = (Issue) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (issueId == null) {
			if (other.issueId != null)
				return false;
		} else if (!issueId.equals(other.issueId))
			return false;
		if (priority != other.priority)
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", title=" + title
				+ ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", creationDate=" + creationDate
				+ ", type=" + type + "]";
	}
	
}
