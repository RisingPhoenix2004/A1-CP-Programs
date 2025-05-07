
/*
 * A graduate at University of China (UoC) has to follow certain rules. The
 * rules are as follows:
 * 
 * UoC offering K subjects, the subjects are indexed from 0 to K-1.
 * Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which
 * specifies you must
 * take the subject Yi before the subject Xi.
 * 
 * You are given total number of subjects and a list of the condition pairs.
 * Return the ordering of subjects that a graduate should take to finish all
 * subjects.
 * - the result set should follow the given order of conditions.
 * - If it is impossible to complete all subjects, return an empty set.
 * 
 * Input Format:
 * -------------
 * Line-1: An integer K, number of subjects.
 * Line-2: An integer C, number of conditions.
 * Next C lines: Two space separated integers, Xi and Yi.
 * 
 * Output Format:
 * --------------
 * Return a list of integers, the ordering of subjects that a graduate should
 * take to finish all subjects
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 4
 * 3
 * 1 2
 * 3 0
 * 0 1
 * 
 * Sample Output-1:
 * ----------------
 * [2, 1, 0, 3]
 * 
 * Explanation-1:
 * --------------
 * There are a total of 4 courses to take.
 * Subject 1 should be taken after you finished subject 2.
 * Subject 3 should be taken after you finished subject 0.
 * Subject 0 should be taken after you finished subject 1.
 * So the correct subject order is [2, 1, 0, 3].
 * 
 * Sample Input-2:
 * ---------------
 * 5
 * 5
 * 0 1
 * 1 2
 * 2 3
 * 3 4
 * 4 0
 * 
 * Sample Output-2:
 * ----------------
 * []
 * 
 * Explanation-2:
 * -------------
 * No subject can be completed because they depend on each other.
 */
import java.util.*;
import java.io.*;

class CourseSchedule {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		int[] indegree = new int[numCourses];
		List<Integer> order = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] pair : prerequisites) {
			int course = pair[0];
			int prereq = pair[1];
			graph[prereq].add(course);
			indegree[course]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			order.add(current);

			for (int neighbor : graph[current]) {
				indegree[neighbor]--;
				if (indegree[neighbor] == 0) {
					queue.offer(neighbor);
				}
			}
		}

		if (order.size() == numCourses) {
			int[] result = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				result[i] = order.get(i);
			}
			return result;
		}

		return new int[0];
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int courses = sc.nextInt();
		int nprerequisites = sc.nextInt();
		int[][] prerequisites = new int[nprerequisites][2];
		for (int i = 0; i < nprerequisites; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			prerequisites[i][0] = a;
			prerequisites[i][1] = b;
		}
		int[] result = new CourseSchedule().findOrder(courses, prerequisites);
		System.out.println(Arrays.toString(result));
	}
}
