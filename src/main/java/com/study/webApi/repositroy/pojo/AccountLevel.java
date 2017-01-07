package com.study.webApi.repositroy.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.study.infrastructure.domain.EntityBase;

public class AccountLevel extends EntityBase<Integer> implements Serializable, Comparable<AccountLevel>, Cloneable {

	private static final long serialVersionUID = 112460837672595219L;
	public final static String TABLE_NAME = "account_level";
	public final static String COLUMN_ID = "id";
	public final static String COLUMN_CREATE_TIME = "create_time";
	public final static String COLUMN_UPDATE_TIME = "update_time";
	public final static String COLUMN_POINT = "point";
	public final static String COLUMN_LEVEL = "level";

	private Timestamp createTime;
	private Timestamp updateTime;
	private long point;
	private int level;
	private long currentLevelMinPoint;
	private long currentLevelMaxPoint;

	public AccountLevel() {
	}

	public AccountLevel(Integer id, Timestamp createTime, Timestamp updateTime, long point, int level) {
		super(id);
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.point = point;
		this.level = level;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getCurrentLevelMinPoint() {
		return currentLevelMinPoint;
	}

	public void setCurrentLevelMinPoint(long currentLevelMinPoint) {
		this.currentLevelMinPoint = currentLevelMinPoint;
	}

	public long getCurrentLevelMaxPoint() {
		return currentLevelMaxPoint;
	}

	public void setCurrentLevelMaxPoint(long currentLevelMaxPoint) {
		this.currentLevelMaxPoint = currentLevelMaxPoint;
	}
	
	public void growUp(long point) {
		this.point += point;
	}
	public void increateLevel() {
		this.level += 1;
	}
	@Override
	public int compareTo(AccountLevel another) {
		return this.getLevel() - another.getLevel();
	}

	@Override
	protected void validate() {
		// TODO Auto-generated method stub
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		AccountLevel entity = null;
		try {
			entity = (AccountLevel) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return entity;
	}

}
