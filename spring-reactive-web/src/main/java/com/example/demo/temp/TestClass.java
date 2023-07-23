package com.example.demo.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {
        String dataString = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "Jay.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        var list = parseStringData(dataString);



        convertFileInformationToNewStringFormat(list);
        list.sort(Comparator.comparingInt(FileInfo::getOrderNumber));

        String strResult = list.stream().map(FileInfo::getNewFileName).collect(Collectors.joining("\n"));
        //var stringResult = String.join("\n", list);
        System.out.println(strResult);
    }

    private static void convertFileInformationToNewStringFormat(List<FileInfo> list) {

        list.stream().collect(Collectors.groupingBy(FileInfo::getCity)).forEach((s, fileInfos) -> {
            var size = fileInfos.size();
            var stringMaxLength = String.valueOf(size).length();
            fileInfos.sort(Comparator.comparing(FileInfo::getDatetime));
            for (int i = 0; i < fileInfos.size(); i++) {
                var orderNumber = fixLengthWithLeadingZeros(i+1, stringMaxLength);
                var file = fileInfos.get(i);
                file.setNewFileName(file.getCity() + orderNumber + "." + file.extension);
            }
        });
    }

    static class FileInfo {
        public String imageName;
        public String extension;
        public String city;
        public Date datetime;
        public int orderNumber;
        public String newFileName;

        public String getNewFileName() {
            return newFileName;
        }

        public void setNewFileName(String newFileName) {
            this.newFileName = newFileName;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Date getDatetime() {
            return datetime;
        }

        public void setDatetime(Date datetime) {
            this.datetime = datetime;
        }

        public int getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(int orderNumber) {
            this.orderNumber = orderNumber;
        }

        public void print() {
            // Output the extracted information
            System.out.println("Image Name: " + imageName);
            System.out.println("Extension: " + extension);
            System.out.println("City: " + city);
            System.out.println("Datetime: " + datetime);
            System.out.println("orderNumber: " + orderNumber);
        }
    }

    public static List<FileInfo> parseStringData(String dataString) {

        List<FileInfo> list = new ArrayList<>();

        String[] lines = dataString.split("\n");
        int order = 0;
        for (String line : lines) {
            line = line.trim();
            String[] parts = line.split(",");
            FileInfo fileInfo = new FileInfo();
            // Extract the image name and extension
            String imageName = parts[0].trim();
            String[] imageNameParts = imageName.split("\\.");
            fileInfo.imageName = imageNameParts[0].trim();
            fileInfo.extension = imageNameParts[1].trim();

            // Extract the city
            fileInfo.city = parts[1].trim();

            // Extract the datetime
            String datetime = parts[2].trim();
            fileInfo.datetime = stringToDateConvertor(datetime);
            fileInfo.orderNumber = order++;
            list.add(fileInfo);


        }
        return list;
    }

    private static Date stringToDateConvertor(String strDate) {

        String format = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            System.out.println("Failed to parse date: " + e.getMessage());
        }
        return null;
    }

    public static String fixLengthWithLeadingZeros(int number, int fixedSize) {
        return String.format("%0" + fixedSize + "d", number);
    }
}
