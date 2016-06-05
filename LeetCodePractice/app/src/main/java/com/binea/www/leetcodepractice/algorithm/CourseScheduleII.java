package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubinggui on 6/5/16.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 */
public class CourseScheduleII {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take
     * course 1, which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, return the ordering of
     * courses you should take to finish all courses.
     *
     * There may be multiple correct orders, you just need to return one of them. If it is
     * impossible to finish all courses, return an empty array.
     *
     * For example:
     *
     * 2, [[1,0]]
     * There are a total of 2 courses to take. To take course 1 you should have finished course 0.
     * So the correct course order is [0,1]
     *
     * 4, [[1,0],[2,0],[3,1],[3,2]]
     * There are a total of 4 courses to take. To take course 3 you should have finished both
     * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one
     * correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
     *
     * Note:
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
     * Read more about how a graph is represented.
     */
    private int N = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i], result)) {
                return new int[0];
            }
        }
        return result;
    }

    private boolean isCyclic(Course cur, int[] result) {
        if (cur.tested) return false;
        if (cur.visited) return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c, result)) {
                return true;
            }
        }
        cur.tested = true;
        result[N++] = cur.number;
        return false;
    }

    class Course {
        boolean visited = false;
        boolean tested = false;
        int number;
        List<Course> pre = new ArrayList<Course>();
        public Course(int i) {
            number = i;
        }
        public void add(Course c) {
            pre.add(c);
        }
    }
}
