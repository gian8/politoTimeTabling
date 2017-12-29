/*
 * Copyright (C) 2017 gianluca.mangiapelo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package polito.timetabling;

/**
 *
 * @author gianluca.mangiapelo
 */
public class Ant {
    protected int trailSize;
	protected int trail[];
	protected boolean visited[];

	public Ant(int tourSize) {
		this.trailSize = tourSize;
		this.trail = new int[tourSize];
		this.visited = new boolean[tourSize];
	}

	protected void visitCity(int currentIndex, int city) {
		trail[currentIndex + 1] = city;
		visited[city] = true;
	}

	protected boolean visited(int i) {
		return visited[i];
	}

	protected double trailLength(double graph[][]) {
		double length = graph[trail[trailSize - 1]][trail[0]];
		for (int i = 0; i < trailSize - 1; i++) {
			length += graph[trail[i]][trail[i + 1]];
		}
		return length;
	}

	protected void clear() {
		for (int i = 0; i < trailSize; i++)
			visited[i] = false;
	}
}
