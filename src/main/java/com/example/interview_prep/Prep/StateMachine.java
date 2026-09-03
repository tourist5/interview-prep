package com.example.interview_prep.Prep;

import java.util.*;

public class StateMachine {

    static class Log {

        int timestamp;
        String vehicleNumber;
        String state;

        Log(int timestamp, String vehicleNumber, String state) {
            this.timestamp = timestamp;
            this.vehicleNumber = vehicleNumber;
            this.state = state;
        }
    }

    public static void main(String[] args) {
//        List<Log> logs = Arrays.asList(
//                new Log(100,"ABC123","ENTRY"),
//                new Log(120,"XYZ111","ENTRY"),
//                new Log(130,"ABC123","MAINROAD"),
//                new Log(150,"ABC123","EXIT"),
//                new Log(170,"XYZ111","EXIT"),
//                new Log(180,"ABC123","EXIT")
//        );
//
//        System.out.println(totalCompleteJourney(logs));

//                List<LoginDetail> logs = Arrays.asList(
//                new LoginDetail(100,"Alice","LOGIN"),
//                new LoginDetail(120,"Bob","LOGIN"),
//                new LoginDetail(180,"Alice","LOGOUT"),
//                new LoginDetail(240,"Bob","LOGOUT")
//        );
//
//        System.out.println(averageDuration(logs));

        List<String> users = List.of("Alice",
                "Bob",
                "Alice",
                "John",
                "Bob",
                "Alice",
                "David",
                "John",
                "Alice");
        System.out.println(topKFrequentUsers(users,2));

//        String s = "44776.619 KTB918 310E MAINROAD";
//        tollBooth(s);


    }

    public static int totalCompleteJourney(List<Log> logs) {
        logs.sort((a, b) -> Integer.compare(a.timestamp, b.timestamp));

        Set<String> entryVehicleDetails = new HashSet<>();
        int totalCompletedJourney = 0;
        for (Log currentRow : logs) {
            String vehicleNumber = currentRow.vehicleNumber;
            String state = currentRow.state;
            if ("ENTRY".equals(state)) {
                entryVehicleDetails.add(vehicleNumber);
            } else if ("EXIT".equals(state)) {
                if (entryVehicleDetails.contains(vehicleNumber)) {
                    totalCompletedJourney++;
                    entryVehicleDetails.remove(vehicleNumber);
                }
            }
        }


        return totalCompletedJourney;
    }

    static class LoginDetail {
        int timeStamp;
        String person;
        String status;

        LoginDetail(int timeStamp, String person, String status) {
            this.timeStamp = timeStamp;
            this.person = person;
            this.status = status;
        }

    }

    public static double averageDuration(List<LoginDetail> loginDetailList) {
        loginDetailList.sort(Comparator.comparingInt(loginDetail -> loginDetail.timeStamp));
        Map<String, Integer> keyIsPersonAndValueIsTimeStamp = new HashMap<>();
        int totalTime = 0;
        int differentDurations = 0;

        for (LoginDetail currentLoginDetail : loginDetailList) {
            String person = currentLoginDetail.person;
            String status = currentLoginDetail.status;
            Integer timeStamp = currentLoginDetail.timeStamp;

            if ("LOGIN".equals(status)) {
                if (keyIsPersonAndValueIsTimeStamp.containsKey(person)) {
                    continue;
                }
                keyIsPersonAndValueIsTimeStamp.put(person, timeStamp);
            } else {
                if (!keyIsPersonAndValueIsTimeStamp.containsKey(person)) {
                    continue;
                }
                Integer loginTime = keyIsPersonAndValueIsTimeStamp.get(person);
                int timeDuration = timeStamp - loginTime;
                totalTime += timeDuration;
                differentDurations++;
                keyIsPersonAndValueIsTimeStamp.remove(person);
            }
        }

        return (double) totalTime / differentDurations;
    }

    static class UserFreq {
        String user;
        Integer freq;

        UserFreq(String user, Integer freq) {
            this.user = user;
            this.freq = freq;
        }
    }

    public static List<String> topKFrequentUsers(List<String> users, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> keyIsUserAndValueIsFreq = new HashMap<>();
        for (String currentUser : users) {
            keyIsUserAndValueIsFreq.put(currentUser, keyIsUserAndValueIsFreq.getOrDefault(currentUser, 0) + 1);
        }
        System.out.println(keyIsUserAndValueIsFreq);
        PriorityQueue<UserFreq> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.freq, b.freq));
        for (Map.Entry<String, Integer> map : keyIsUserAndValueIsFreq.entrySet()) {
            String user = map.getKey();
            Integer freq = map.getValue();
            pq.offer(new UserFreq(user,freq));
            if(pq.size()>k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            UserFreq userFreq = pq.poll();
            ans.add(userFreq.user);
        }


        return ans.reversed();
    }

//44776.619 KTB918 310E MAINROAD

    public static void tollBooth(String input) {
        String[] arr = input.split(" ");
        double timeStamp = Double.parseDouble(arr[0]);
        String licence = arr[1];
        int location = Integer.parseInt(arr[2].substring(0, arr[2].length() - 1));
        char dir = arr[2].charAt(arr[2].length() - 1);
        String direction = dir == 'E' ? "EAST" : "WEST";
        String booth = arr[3];

        System.out.println(timeStamp);
        System.out.println(licence);
        System.out.println(location);
        System.out.println(direction);
        System.out.println(booth);

    }


}
