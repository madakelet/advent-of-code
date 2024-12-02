package year2023.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Day19 {
    static List<Rating> ratings = new ArrayList<Rating>();
    static Map<String, List<Condition>> workflows = new HashMap<String, List<Condition>>();
    static List<Rating> accepted = new ArrayList<Rating>();
    static List<Rating> rejected = new ArrayList<Rating>();

    public static void main(String[] args) {
        String lines = utils.ReadFile.readFromFile("year2023/day19/input.txt");
        processLine(lines);
        for (Rating rating : ratings) {
            System.out.println("Rating: " + rating.x + ", " + rating.m + ", " + rating.a
                    + ", " + rating.s);
            processRating(rating, "in");
        }
        int sum = 0;
        for(Rating rating : accepted) {
            sum += rating.sum();
        }
        System.out.println("Sum of accepted ratings: " + sum);
    }

    public static void addRating(String line) {
        line = line.replace("{", "");
        line = line.replace("}", "");
        Rating rating = new Rating();
        for (String splitByComma : line.split(",")) {
            String[] splitByEquals = splitByComma.split("=");
            switch (splitByEquals[0]) {
                case "x":
                    rating.x = Integer.parseInt(splitByEquals[1]);
                    break;
                case "m":
                    rating.m = Integer.parseInt(splitByEquals[1]);
                    break;
                case "a":
                    rating.a = Integer.parseInt(splitByEquals[1]);
                    break;
                case "s":
                    rating.s = Integer.parseInt(splitByEquals[1]);
                    break;
                default:
                    System.out.println("Error: " + splitByEquals[0] + " is not a valid field name.");
                    break;
            }
        }
        ratings.add(rating);
    }

    public static void addWorkflow(String line) {
        line = line.replace("}", "");
        String[] split = line.split("\\{");
        String workflowName = split[0];
        List<Condition> conditions = new ArrayList<Condition>();
        for (String condition : split[1].split(",")) {
            if (condition.contains(":")) {
                String[] splitByColon = condition.split(":");
                String destination = splitByColon[1];
                if (splitByColon[0].contains(">")) {
                    String[] splitByOperator = splitByColon[0].split(">");
                    String operator = ">";
                    String source = splitByOperator[0];
                    int value = Integer.parseInt(splitByOperator[1]);
                    conditions.add(new Condition(value, destination, operator, source));
                } else if (splitByColon[0].contains("<")) {
                    String[] splitByOperator = splitByColon[0].split("<");
                    String operator = "<";
                    String source = splitByOperator[0];
                    int value = Integer.parseInt(splitByOperator[1]);
                    conditions.add(new Condition(value, destination, operator, source));
                }
            } else {
                conditions.add(new Condition(condition));
            }
        }
        workflows.put(workflowName, conditions);
    }

    public static void processLine(String lines) {
        boolean empty = false;
        for (String line : lines.split("\n")) {
            if (line.equals("") && !empty) {
                empty = true;
            }
            if (!empty && !line.equals("")) {
                addWorkflow(line);
            } else if (empty && !line.equals("")) {
                addRating(line);
            }
        }
    }

    public static void processRating(Rating rating, String workflowName) {
        System.out.println("Processing workflow: " + workflowName);
        if (workflows.containsKey(workflowName)) {
            List<Condition> conditions = workflows.get(workflowName);
            boolean found = false;
            int i = 0;
            while (!found) {
                Condition condition = conditions.get(i);
                if (condition.source == null) {
                    found = true;
                    if (condition.destination.equals("A")) {
                        accepted(rating);
                    } else if (condition.destination.equals("R")) {
                        rejected(rating);
                    } else {
                        processRating(rating, condition.destination);
                    }
                } else {
                    int value = 0;
                    switch (condition.source) {
                        case "x":
                            value = rating.x;
                            break;
                        case "m":
                            value = rating.m;
                            break;
                        case "a":
                            value = rating.a;
                            break;
                        case "s":
                            value = rating.s;
                            break;
                        default:
                            System.out.println("Error: " + condition.source + " is not a valid field name.");
                            break;
                    }
                    switch (condition.operator) {
                        case ">":
                            if (value > condition.value) {
                                found = true;
                                if (condition.destination.equals("A")) {
                                    accepted(rating);
                                } else if (condition.destination.equals("R")) {
                                    rejected(rating);
                                } else {
                                    processRating(rating, condition.destination);
                                }
                            }
                            break;
                        case "<":
                            if (value < condition.value) {
                                found = true;
                                if (condition.destination.equals("A")) {
                                    accepted(rating);
                                } else if (condition.destination.equals("R")) {
                                    rejected(rating);
                                } else {
                                    processRating(rating, condition.destination);
                                }
                            }
                            break;
                        default:
                            System.out.println("Error: " + condition.operator + " is not a valid operator.");
                            break;
                    }
                }
                i++;
            }
        } else {
            if (workflowName.equals("A")) {
                accepted(rating);
                return;
            } else if (workflowName.equals("R")) {
                rejected(rating);
                return;
            } else {
                System.out.println("Error: " + workflowName + " is not a valid workflow name.");
                return;
            }
        }
    }

    public static void printWorkflows() {
        for (Map.Entry<String, List<Condition>> entry : workflows.entrySet()) {
            System.out.println("Workflow: " + entry.getKey());
            for (Condition condition : entry.getValue()) {
                System.out.println(condition.toString());
            }
        }
    }

    public static void accepted(Rating rating) {
        System.out.println("Rating accepted: " + rating.x + ", " + rating.m + ", " + rating.a + ", " + rating.s);
        accepted.add(rating);
    }

    public static void rejected(Rating rating) {
        System.out.println("Rating rejected: " + rating.x + ", " + rating.m + ", " + rating.a + ", " + rating.s);
        rejected.add(rating);
    }
}
