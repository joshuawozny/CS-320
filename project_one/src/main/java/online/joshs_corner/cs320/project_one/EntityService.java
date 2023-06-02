/**
 * 
 */
package online.joshs_corner.cs320.project_one;

/**
 * @author jwozny
 *
 */
interface EntityService {
	void add(Entity entity);
	void deleteById(String id);
	void update(String id, String ...updatedValues);
}
