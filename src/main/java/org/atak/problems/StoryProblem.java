package org.atak.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * When a person who knows it meets any other person, they immediately share the story with them.
 * Initially, only person 1 knows the story. Given a list of meetings between people in a form of
 * (person_1_id, person_2_id, timestamp) construct a list of the persons who will know the story at
 * the very end.
 * <p>
 * Example: [(1, 2, 100), (3,4, 200), (1,3, 300), (2,5, 400)], 1 // The events could be out of
 * order. Person 2 will learn the story at the moment 100, person 3 — at the moment 300, person 5 —
 * in the moment 400. Person 4 will never learn the story. So the answer is [1, 2, 3, 5].
 * <p>
 * Eg2: [(1, 2, 100), (2, 3, 100), (4, 5, 100)], 2 where the first parameter is array of the Persons
 * meet at particular timestamp, second parameter is the PersonId who knows the story first. Output:
 * [1, 2, 3]
 */
public class StoryProblem {

  public static void main(String[] args) {
    final Conversation c1 = new Conversation(1, 2, 100);
    final Conversation c2 = new Conversation(3, 4, 200);
    final Conversation c3 = new Conversation(1, 3, 300);
    final Conversation c4 = new Conversation(2, 5, 400);

    final Conversation c5 = new Conversation(1, 2, 100);
    final Conversation c6 = new Conversation(2, 3, 200);
    final Conversation c7 = new Conversation(4, 5, 300);

    final Conversation[] conversations = {c5, c6, c7};
    System.out.println(new StoryProblem().peopleWhoKnowTheStory(conversations, 2));
  }

  public Set<Integer> peopleWhoKnowTheStory(final Conversation[] conversations,
      final int personWhoKnew) {
    if (conversations.length == 0) {
      return null;
    }

    final Set<Integer> people = new HashSet<>();
    people.add(personWhoKnew);
    for (final Conversation c : conversations) {
      if (people.contains(c.person1)) {
        people.add(c.person2);
        continue;
      }

      if (people.contains(c.person2)) {
        people.add(c.person1);
      }
    }

    return people;
  }
}

class Conversation {

  final int person1;
  final int person2;
  final int timestamp;

  public Conversation(int person1, int person2, int timestamp) {
    this.person1 = person1;
    this.person2 = person2;
    this.timestamp = timestamp;
  }


}

