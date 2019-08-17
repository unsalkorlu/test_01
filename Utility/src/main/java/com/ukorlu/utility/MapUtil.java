package com.ukorlu.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MapUtil {

	public static HashMap<String, Integer> sortHashMapWithIntegerValues(Map<String, Integer> input) {
		Map<String, Integer> tempMap = new HashMap<>();
		for (String wsState : input.keySet()) {
			tempMap.put(wsState, input.get(wsState));
		}

		List<String> mapKeys = new ArrayList<>(tempMap.keySet());
		List<Integer> mapValues = new ArrayList<>(tempMap.values());
		HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		TreeSet<Integer> sortedSet = new TreeSet<>(Collections.reverseOrder());
		sortedSet.addAll(mapValues);
		Object[] sortedArray = sortedSet.toArray();
		for (Object o : sortedArray) {
			sortedMap.put(mapKeys.get(mapValues.indexOf(o)), (Integer) o);
		}
		return sortedMap;
	}

	public static HashMap<String, Integer> sortHashMapWithStringKeysAndIntegerValues(Map<String, Integer> input,
			boolean descending) {
		Map<String, Integer> tempMap = new HashMap<>();
		for (String wsState : input.keySet()) {
			tempMap.put(wsState, input.get(wsState));
		}

		List<String> mapKeys = new ArrayList<>(tempMap.keySet());
		HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		TreeSet<String> sortedSet;
		if (descending) {
			sortedSet = new TreeSet<>(Collections.reverseOrder());
			sortedSet.addAll(mapKeys);
		} else {
			sortedSet = new TreeSet<>(mapKeys);
		}
		Object[] sortedArray = sortedSet.toArray();
		for (Object o : sortedArray) {
			sortedMap.put((String) o, input.get(o));
		}
		return sortedMap;
	}

	public static HashMap<String, Long> sortHashMapWithStringKeysAndLongValues(Map<String, Long> input,
			boolean descending) {
		Map<String, Long> tempMap = new HashMap<>();
		for (String wsState : input.keySet()) {
			tempMap.put(wsState, input.get(wsState));
		}

		List<String> mapKeys = new ArrayList<>(tempMap.keySet());
		HashMap<String, Long> sortedMap = new LinkedHashMap<>();
		TreeSet<String> sortedSet;
		if (descending) {
			sortedSet = new TreeSet<>(Collections.reverseOrder());
			sortedSet.addAll(mapKeys);
		} else {
			sortedSet = new TreeSet<>(mapKeys);
		}
		Object[] sortedArray = sortedSet.toArray();
		for (Object o : sortedArray) {
			sortedMap.put((String) o, input.get(o));
		}
		return sortedMap;
	}

	public static HashMap<String, Long> sortHashMapWithLongValues(Map<String, Long> input) {
		Map<String, Long> tempMap = new HashMap<String, Long>();
		for (String wsState : input.keySet()) {
			tempMap.put(wsState, input.get(wsState));
		}

		List<String> mapKeys = new ArrayList<>(tempMap.keySet());
		List<Long> mapValues = new ArrayList<>(tempMap.values());
		HashMap<String, Long> sortedMap = new LinkedHashMap<String, Long>();
		TreeSet<Long> sortedSet = new TreeSet<>(Collections.reverseOrder());
		sortedSet.addAll(mapValues);
		Object[] sortedArray = sortedSet.toArray();
		for (Object o : sortedArray) {
			sortedMap.put(mapKeys.get(mapValues.indexOf(o)), (Long) o);
		}
		return sortedMap;
	}

	public static HashMap<String, Integer> sortHashMapWithIntegerValues(Map<String, Integer> input,
			boolean descending) {
		Map<String, Integer> tempMap = new HashMap<>();
		for (String wsState : input.keySet()) {
			tempMap.put(wsState, input.get(wsState));
		}

		List<String> mapKeys = new ArrayList<>(tempMap.keySet());
		List<Integer> mapValues = new ArrayList<>(tempMap.values());
		HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		TreeSet<Integer> sortedSet;
		if (descending) {
			sortedSet = new TreeSet<>(Collections.reverseOrder());
			sortedSet.addAll(mapValues);
		} else {
			sortedSet = new TreeSet<>(mapValues);
		}
		sortedSet.addAll(mapValues);
		Object[] sortedArray = sortedSet.toArray();
		int size = sortedArray.length;
		for (Object o : sortedArray) {
			sortedMap.put(mapKeys.get(mapValues.indexOf(o)), (Integer) o);
		}
		return sortedMap;
	}

	public static HashMap<String, Long> sortHashMapWithLongValues(Map<String, Long> input, boolean descending) {
		Map<String, Long> tempMap = new HashMap<>();
		for (String wsState : input.keySet()) {
			tempMap.put(wsState, input.get(wsState));
		}

		List<String> mapKeys = new ArrayList<>(tempMap.keySet());
		List<Long> mapValues = new ArrayList<>(tempMap.values());
		HashMap<String, Long> sortedMap = new LinkedHashMap<>();
		TreeSet<Long> sortedSet;
		if (descending) {
			sortedSet = new TreeSet<>(Collections.reverseOrder());
			sortedSet.addAll(mapValues);
		} else {
			sortedSet = new TreeSet<>(mapValues);
		}

		Object[] sortedArray = sortedSet.toArray();
		for (Object o : sortedArray) {
			sortedMap.put(mapKeys.get(mapValues.indexOf(o)), (Long) o);
		}
		return sortedMap;
	}
}