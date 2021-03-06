package  com.elton.app.repository.redis;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.elton.app.domain.Category;
import com.elton.app.support.RedisHelper;

@Repository
public class CategoryRepositoryRedisImpl implements CategoryRepositoryRedis{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public Category insert(final Category category) {
		final String categoryKey = RedisHelper.generateCategoriesKey(category.getId());
		redisTemplate.opsForValue().set(categoryKey, RedisHelper.deserializableToString(category));
		return RedisHelper.serializableToObject(redisTemplate.opsForValue().get(categoryKey), Category.class);
	}

	@Override
	public Optional<Category> findByDescriptionEqualsIgnoreCase(final String description) {
		final List<String> listJsonCategory= redisTemplate.opsForValue().multiGet(redisTemplate.keys("categories:*"));
		final List<Category> listCategory= listJsonCategory.stream().map(json -> RedisHelper.serializableToObject(json, Category.class)).collect(Collectors.toList());
		return listCategory.stream().filter(x -> x.getDescription().equalsIgnoreCase(description)).findFirst();
	}
}