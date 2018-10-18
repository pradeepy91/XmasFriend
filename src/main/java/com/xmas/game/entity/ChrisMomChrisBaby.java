package com.xmas.game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CHRISMOM_CHRISBABY")
public class ChrisMomChrisBaby {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	Long id;
	Long chirsMom;
	Long chrisBaby;
	Long groupId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getChirsMom() {
		return chirsMom;
	}
	public void setChirsMom(Long chirsMom) {
		this.chirsMom = chirsMom;
	}
	public Long getChrisBaby() {
		return chrisBaby;
	}
	public void setChrisBaby(Long chrisBaby) {
		this.chrisBaby = chrisBaby;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
