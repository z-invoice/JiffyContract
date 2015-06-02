package com.nordicusability.jiffy.contract.data;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OwnerHierarchy {

	private static class Hierarchy {
		Hierarchy parent;
		private final Owner owner;
		List<Hierarchy> children = new ArrayList<>();

		public Hierarchy(Owner owner) {
			this.owner = owner;
		}
	}

	private final UUID zeroUuid = new UUID(0, 0);

	private List<Owner> flatList = new ArrayList<>();
	private Map<UUID, Owner> uuidMap = new HashMap<>();
	private Map<UUID, Hierarchy> hierarchyMap = new HashMap<>();

	private List<Hierarchy> root = new ArrayList<>();

	public OwnerHierarchy(Cursor cursor) {
		while (cursor.moveToNext()) {
			Owner owner = new Owner(cursor);
			flatList.add(owner);
			uuidMap.put(owner.getUuid(), owner);
		}

		buildHierarchy();

	}

	private void buildHierarchy() {
		for (Owner owner : flatList) {
			Hierarchy hierarchy = getHierarchy(owner.uuid);
			hierarchy.parent = getHierarchy(owner.getParentUUID());
			hierarchy.parent.children.add(hierarchy);
		}
	}

	private Hierarchy getHierarchy(UUID uuid) {
		Hierarchy hierarchy = hierarchyMap.get(uuid);
		if (hierarchy == null) {
			hierarchy = new Hierarchy(uuidMap.get(uuid));
			hierarchyMap.put(uuid, hierarchy);
		}
		return hierarchy;
	}

	private List<Owner> convert(List<Hierarchy> hierarchies) {
		List<Owner> result = new ArrayList<>();
		for (Hierarchy hierarchy : hierarchies) {
			result.add(hierarchy.owner);
		}
		return result;
	}

	public List<Owner> getCustomers() {
		return convert(hierarchyMap.get(zeroUuid).children);
	}

	public List<Owner> getProjects() {
		List<Owner> result = new ArrayList<>();
		for (Hierarchy child : hierarchyMap.get(zeroUuid).children) {
			result.addAll(convert(hierarchyMap.get(child.owner.getUuid()).children));
		}
		return result;
	}

	public Owner get(UUID uuid){
		return uuidMap.get(uuid);
	}

	public List<Owner> getChildren(Owner owner) {
		Hierarchy hierarchy = hierarchyMap.get(owner.getUuid());
		return convert(hierarchy.children);
	}

	public Owner getParent(Owner owner) {
		return uuidMap.get(owner.getParentUUID());
	}

}
