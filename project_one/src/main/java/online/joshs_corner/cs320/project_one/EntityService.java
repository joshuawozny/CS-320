package online.joshs_corner.cs320.project_one;

import java.util.HashMap;

public class EntityService {
	//Private properties
	private final HashMap<String, Entity> entities = new HashMap<String, Entity>();		
	
	//Public API CRUD Methods for all Entities
	public void addEntity(Entity entity) throws Exception {
		//Validation
		if(entities.containsKey(entity.getId())) {
			throw new Exception("Entity already exists.");
		}
		else {
			this.entities.put(entity.getId(), entity);
		}
	}
	public void deleteEntityById(String id) {
		entities.remove(id);
	}
	public void update(Entity entity) throws Exception {
		//Validation
		if(entities.containsKey(entity.getId())) {
			this.entities.put(entity.getId(), entity);
		}
		else {
			throw new Exception("Entity does not exist.");
		}
	}
	public Entity getEntityById(String id) {
		return entities.get(id);
	}
	public Boolean entityExists(String id) {
		return entities.containsKey(id);
	}
}
