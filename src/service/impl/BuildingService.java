package service.impl;

import entity.*;

import java.util.ArrayList;

public class BuildingService {
    protected static final ArrayList<Building> buildingList = new ArrayList<>();

    public static void addBuildingToBuildingList() {
        int index = 1;
        int buildingQuantity = 5;
        while (index <= buildingQuantity) {
            Building building = new Building();
            addBuildingInformation(building, index);
            addBuildingToBuildingListProcess(building);
            index++;
        }
    }

    public static void addBuildingInformation(Building building, int index) {
        building.setBuildingName(createBuildingName());
        building.setId(index);
    }

    protected static String createBuildingName() {
        int nameNumber = 1;
        for (int i = 1; i <= buildingList.size(); i++) {
            nameNumber++;
        }
        return "Building " + nameNumber;
    }

    protected static void addBuildingToBuildingListProcess(Building building) {
        buildingList.add(building);
    }
}
