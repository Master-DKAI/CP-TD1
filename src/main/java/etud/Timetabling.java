package etud;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

/**
 * TD2 - Exercise 5: University Timetabling with Choco-Solver.
 *
 * Skeleton to complete: TODO 1, TODO 2, TODO 3 and TODO 4 below.
 */
public class Timetabling {

    public static void main(String[] args) {
        Model model = new Model("University Timetabling");

        int nbSlots = 6;                 // slots 1..6 (Mon: 1-3, Tue: 4-6)
        String[] course  = {"C1", "C2", "C3", "C4", "C5", "C6"};
        String[] teacher = {"T1", "T2", "T1", "T3", "T4", "T2"};
        // groups attending each course: {L3A, L3B}
        boolean[][] group = {
            {true, false}, {true, false}, {false, true},
            {true, true},  {true, false}, {false, true}
        };
        int[] attendance = {35, 35, 20, 55, 35, 20};

        // one IntVar "slot_i" per course, domain [1, nbSlots]
        IntVar[] slot = new IntVar[course.length];
        for (int i = 0; i < course.length; i++) {
            slot[i] = model.intVar("slot_" + course[i], 1, nbSlots);
        }

        // TODO 1: for every pair (i, j) taught by the same teacher,
        //         post slot[i] != slot[j]

        // TODO 2: for every pair (i, j) sharing at least one group,
        //         post slot[i] != slot[j]

        // TODO 3: introduce a room_i variable per course (domain among
        //         the rooms whose capacity is sufficient: R1 = capacity 60,
        //         R2 = capacity 25) and post a constraint forbidding two
        //         courses in the same room at the same slot

        boolean found = model.getSolver().solve();

        // TODO 4: print the resulting timetable (found / slot / room per course)
        if (!found) {
            System.out.println("No timetable found.");
        }
    }
}
