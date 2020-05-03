/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.OOP;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class TeamCloneable implements Cloneable {
	private Person coach;
	private List<Person> players;

	public TeamCloneable() {
		players = new ArrayList<>();
		coach = new Person();
	}

	public void addPlayer(Person p) {
		players.add(p);
	}

	public Person getCoach() {
		return coach;
	}

	//Must implement clone method.
	@Override
	public Object clone() throws CloneNotSupportedException {
		TeamCloneable clone = (TeamCloneable) super.clone();
		return clone;
	}

}
