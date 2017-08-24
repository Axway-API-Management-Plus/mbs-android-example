 

package arrowmbs.apis;

import android.os.Looper;

import com.google.gson.reflect.TypeToken;

import arrowmbs.auth.SdkException;
import arrowmbs.SdkClient;
import arrowmbs.Pair;
import arrowmbs.Result;
import arrowmbs.auth.SdkException;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import arrowmbs.models.*;
import com.google.gson.reflect.TypeToken;

public class DefaultAPI {

	private SdkClient client;

	public DefaultAPI(SdkClient client) {
		this.client = client;
	}

	/**
	 * 
	 * Creates a new file object with a binary attachment or contents of a URL.
The size of the file can be up to 25 MB. The response includes a `processed` flag which indicates
if the file has been stored reliably in the Appcelerator Cloud Services
storage engine. This will initially be `false`. Once the file is available in
the storage engine, the `processed` flag will be `true`, and file `url` will
be available.

	 * 
	 * @param name File name.
	 * @param file The attached binary file to upload to ArrowDB. You can specify either `file` or `url`, but not both.
	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this file object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param s3Acl Permission level of the file.  Set to either:

  * `private`: Only a logged-in user can access the file.
  * `public_read`: Anyone can access the file (default).

For private permission, when you retrieve the URL for the file using either the show or
query method, the link is temporary and will expire. The default is five minutes.
When exporting data, the exported URL will be a root URL and not a direct URL to the file.

To restrict file access to specific users, use an ACL.

	 * @param aclId ID of an {@link ACLs} to associate with this file object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the file on behalf of.

The current login user must be an application admin to create a file on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesCreate(String name, File file, String customFields, String aclName, String s3Acl, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (file != null) formParams.put("file", file);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (s3Acl != null) formParams.put("s3_acl", s3Acl);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Key-Value
	 * Deletes a key-value pair

	 * 
	 * @param name Name (or key) of the key-value pair to delete.
	 * @param accessPrivate Determines whether to delete this key-value in the publically readable store
or in the user's private store.

Default is false (publically readable store).

	 * @param suId Delete the key-value pair on behalf of the identified user.

Login user must be an admin to delete a key-value on behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesDelete(String name, Boolean accessPrivate, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling keyValuesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (accessPrivate != null) formParams.put("access_private", accessPrivate);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes a Geofence
	 * Deletes an existing geo-fence object.

	 * 
	 * @param iD ID of the geo-fence object to delete.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject geoFencesDelete(String iD, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling geoFencesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/geo_fences/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * delete
	 * Deletes a scheduled push notification.

The current user must be an application admin to use this API.

	 * 
	 * @param ids Array of push schedule IDs to delete.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushSchedulesDelete(String ids, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_schedule/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (ids != null) formParams.put("ids", ids);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Checkin objects.
	 * Retrieves the total number of Checkin objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Find Facebook Friends
	 * Find the current user's Facebook Friends who also registered in the same App.

	 * 
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject socialIntegrationsFacebookSearchFriends(Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/social/facebook/search_friends.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show File Info
	 * Returns information associated with the file.

	 * 
	 * @param fileId ID of the file to retrieve information for.
	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param expires For private file permission, sets the expiration time in seconds for the temporary link
referencing the location to access the file. By default, the link expires in five minutes.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesShow(String fileId, Integer responseJsonDepth, Integer expires) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'fileId' is set
		if (fileId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'file_id' when calling filesShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "file_id", fileId));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "expires", expires));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create multiple custom objects
	 * Creates up to 100 custom objects.  The current user must be an application admin to use this API.

If there is an error inserting one of the objects, the response payload will return a 200 code, the
number of objects created, and the error for creating the first object that failed. The HTTP
response will be 202.

The `classname` of the object is part of the URL. You do not have to define
`classname` ahead of time. It will be created on the fly.

	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @param jsonArray Array of JSON-encoded objects to create. You may specify up to 100 objects.
You do not have to define fields ahead of time,
simply set key-value pairs of the fields. Since the data must be encoded as
JSON, keys must not contain the dot character.

You may pass the following predefined fields: `acl_id`, `photo_id` and `user_id`, to
attach an ACL, Photo, or User object, respectively. Note that ArrowDB will not check if
the ID exists.

    json_array = [
        {
            custom_field: 'red',
            acl_id: '1234567890abcdef',
            photo_id: '0987654321fedcba',
            user_id: 'ab12cd34ef098765'
        }
    ]

The `tags` field is not supported for the batch create operations.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsBatchCreate(String classname, String jsonArray, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsBatchCreate");
		}
		// verify the required parameter 'jsonArray' is set
		if (jsonArray == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'json_array' when calling customObjectsBatchCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/batch_create.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (jsonArray != null) formParams.put("json_array", jsonArray);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Posts
	 * Performs custom query of posts with sorting and pagination. Currently you can
not query or sort data stored inside array or hash in custom fields.

In addition to custom fields, the following pre-defined fields in posts
that can be queried and sorted:

*   `user_id` : `String`. Post owner's user ID.
*   `title` : `String`. Post title.
*   `event_id` : `String`. ID of the event posts belong to.
*   `tags_array` : `String`. Post tags.
*   `ratings_average` : `Number`. Post's average rating. See {@Reviews}.
*   `ratings_count` : `Number`. Post's total number of ratings. See {@Reviews}.
*   `reviews_count` : `Number`. Post's total number of reviews. See {@Reviews}.
*   `created_at` : `Date`. Timestamp when the post was created.
*   `updated_at` : `Date`. Timestamp when the post was last updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Post object in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects, such as owners and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Updates a checkin for the currenty logged in user.

Application admins can update another user's checkin on their behalf by including the
`su_id` field in the request.

	 * 
	 * @param checkinId ID of the {@link Checkins} to update.

	 * @param placeId ID of the {@link Places} to check in to.

You can associate a checkin with either a {@link Places} or {@link Events} object but not both.

	 * @param eventId ID of the {@link Events} to check in to.

You can associate a checkin with either a {@link Places} or {@link Events} object but not both.

	 * @param message Message to attach to the checkin.
	 * @param photo New {@link Photos} object to attach as the primary photo for the checkin.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing {@link Photos} object to attach as the primary photo for the checkin.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param tags Comma-separated list of tags for this checkin.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId ID of {@link Users} to update the checkin on behalf of.

The current login user must be an application admin to create a checkin on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsUpdate(String checkinId, String placeId, String eventId, String message, File photo, String photoId, Boolean prettyJson, String tags, String customFields, String aclName, String aclId, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'checkinId' is set
		if (checkinId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'checkin_id' when calling checkinsUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (checkinId != null) formParams.put("checkin_id", checkinId);
		if (placeId != null) formParams.put("place_id", placeId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (message != null) formParams.put("message", message);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Review objects.
	 * Retrieves the total number of Review objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Query
	 * **Note:** this API is only available for applications created with ArrowDB 1.1.7 or greater.

Custom query of push notification subscriptions with pagination. For regular (non-admin) application
users, this method returns the currently logged-in user's list of push notification subscriptions.
For app admins, the method returns a list of subscriptions for all users, or just those
for the user specified by as the method's `su_id` parameter.

You can paginate query results using `skip` and `limit` parameters, or `page` and `per_page`, 
but not both in the same query.

	 * 
	 * @param suId User ID of the user who has subscribed devices for push notification.
You must be an application admin to query another user's subscriptions.

If this parameter is not included, a list of subscriptions for all users is returned.

	 * @param channel Name of the push notification channel.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param deviceToken Apple or Android Device Token.
	 * @param type Selects the push type.

Set to `android` for Android devices usingGoogle Cloud Messaging
or `ios` for iOS devices using Apple Push Notification Service.

	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param limit Instead of using `page` and `per_page` for pagination, you can use `limit` and
`skip` to do your own pagination. `limit` is the maximum number of records to `skip`. 
The specified value must be greater than 0 and no greater than 1000, or an HTTP 400 
(Bad Request) error will be returned.

	 * @param skip Number of records to skip. Must be used together with `limit`. The specified value must not
be less than 0 or an HTTP 400 error will be returned.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsQuery(String suId, String channel, String deviceToken, String type, Integer page, Integer perPage, Integer limit, Integer skip, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "su_id", suId));
		queryParams.addAll(client.parameterToPairs("", "channel", channel));
		queryParams.addAll(client.parameterToPairs("", "device_token", deviceToken));
		queryParams.addAll(client.parameterToPairs("", "type", type));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show a Place
	 * Returns information for the identified place.
	 * 
	 * @param placeId ID of the place to show.
	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the identified object, but also
some important data related to the returned objects, such as owners and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param showUserLike If set to **true** the Place object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesShow(String placeId, Integer responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'placeId' is set
		if (placeId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'place_id' when calling placesShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "place_id", placeId));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * update
	 * Updates a scheduled push notification. All parameters specified in the PushSchedules 
{@link PushSchedules#create} method can be updated, with the following exceptions:

  * The schedule's start time cannot be updated, and the `start_time` parameter is ignored, if provided.
  * When specifying a new `end_time` parameter, the new date and time must be greater than 
    the current time, and the previously specified `end_time` value must not have expired.

The current user must be an application administrator to invoke the command.

	 * 
	 * @param schedule Push notification to schedule.
	 * @param iD ID of the PushSchedule object returned by {@link PushSchedules#create}.

	 * @param where 
A JSON-encoded object that defines a location query used to select the devices
that will receive the scheduled notification. Up to 1000 users can be returned by the query. To specify a location query, set the `loc` field to a
[MongoDB Geospatial Query](http://docs.mongodb.org/manual/reference/operator/query-geospatial/).
The following query searches for all users within 2 km of Oakland, CA, USA:

    where={
      "loc": {
        "$nearSphere" : { 
          "$geometry" : { 
            "type" : "Point" , 
            "coordinates" : [-122.2708,37.8044] } , 
            "$maxDistance" : 2000 
          }
        }
      }

For an example of using this parameter, see the REST examples in the PushSchedules {@link PushSchedules#create} method.
For details about using the `where` parameter, see the [Search and Query guide](#!/guide/search_query).

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushSchedulesUpdate(String schedule, String iD, String where, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'schedule' is set
		if (schedule == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'schedule' when calling pushSchedulesUpdate");
		}
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling pushSchedulesUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_schedule/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (schedule != null) formParams.put("schedule", schedule);
		if (iD != null) formParams.put("id", iD);
		if (where != null) formParams.put("where", where);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * set_badge
	 * Sets the value of the internally stored value of the badge.

This method only updates the internally stored value of the badge.  To update the badge value
on the iOS icon or Android notification center, send a push notification with the `badge` field defined.

	 * 
	 * @param deviceToken Device token. Required if you are not an application admin.

	 * @param badgeNumber Number to set as the badge on the application's icon.
Specify postive and negative values with the `+` and `-`
symbols to increment or decrement the current badge number, respectively.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsSetBadge(String deviceToken, String badgeNumber, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/set_badge.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (deviceToken != null) formParams.put("device_token", deviceToken);
		if (badgeNumber != null) formParams.put("badge_number", badgeNumber);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Checkin
	 * Deletes a checkin. 

The {@link #place Place}, {@link #event Event}, or {@link #photo Photo} associated with the checkin
is not deleted.

An application admin can delete any Checkin object.

	 * 
	 * @param checkinId ID of the checkin to delete.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param suId User to delete the Checkin object on behalf of. The user must be the creator of the object.

The current user must be an application admin to delete a Checkin object on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsDelete(String checkinId, Boolean prettyJson, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'checkinId' is set
		if (checkinId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'checkin_id' when calling checkinsDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (checkinId != null) formParams.put("checkin_id", checkinId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * List Chat Groups
	 * Lists chat groups.

If user A sends chat message to user B and C, users A, B and C automatically
form a chat group. Use this API to get a list of chat groups the current user
belongs to.

	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.
See the [Search and Query guide](#!/guide/search_query) for more information.

	 * @param order Sort results by one or more fields.
See the [Search and Query guide](#!/guide/search_query) for more information.

	 * @param responseJsonDepth Nested object depth level counts in JSON response.
To reduce server API calls the JSON response may
include, in addition to the objects returned by the query, other important data related 
to the returned objects, such as object's owner or referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject chatsGetChatGroups(Integer page, Integer perPage, String where, String order, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/chats/get_chat_groups.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Delete the review (comment) with the given `id`. Only the original submitter
can delete the review. If the review has a rating attached to
it, deleting the review will update the average rating and rating summary.

To delete a review, you must specify **both** the ID of the review and the ID of
the reviewed object ({@link #post Post}, {@link #photo Photo}, {@link #user User}, {@link #event Event}, 
{@link #checkin Checkin}, {@link #place Place}, {@link #custom_object CustomObject}, 
{@link #status Status}, or {@link #review Review}. The reviewed object is not deleted, however.

An application admin can delete any Review object.

	 * 
	 * @param reviewId Review object to delete.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsDelete(String reviewId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'reviewId' is set
		if (reviewId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'review_id' when calling reviewsDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (reviewId != null) formParams.put("review_id", reviewId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Increment a Key-Value
	 * Increment the `value` by the given integer value. Not allowed on key-value pairs with binary
data.

If the current value in the key-value is not convertable to an integer, the new
value replaces the existing value.

	 * 
	 * @param name Name (or key) for the key-value pair.
	 * @param value Integer value to add to the current value. If a floating point number is
specified, any fractional portion is dropped.

If this value cannot be converted to an integer, the existing value is not
changed.

	 * @param accessPrivate Determines whether to update this key-value in the publically readable store
or in the user's private store.

Default is false (publically readable).

	 * @param suId Update the key-value pair on behalf of the identified user.

Login user must be an admin to update a key-value on behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesIncrby(String name, String value, Boolean accessPrivate, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling keyValuesIncrby");
		}
		// verify the required parameter 'value' is set
		if (value == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'value' when calling keyValuesIncrby");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/incrby.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (value != null) formParams.put("value", value);
		if (accessPrivate != null) formParams.put("access_private", accessPrivate);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Checkin to a Place or Event
	 * Creates a checkin associated with either a {@link Places} or {@link Events} object. 

You should specify either a Places or Events object, but not both. If both are
provided, the Places object will be used.

A checkin message is optional. The optional photo parameter contains the
binary data stream representing the photo included with the checkin. If a
photo is included, the response includes a "processed" flag which indicates if
the photo has been resized and stored reliably in the Appcelerator Cloud
Services storage engine. This will be false initially be false.

	 * 
	 * @param placeId ID of the {@link Places} to check in to.

You can associate a checkin with either a {@link Places} or {@link Events} object but not both.

	 * @param eventId ID of the {@link Events} to check in to.

You can associate a checkin with either a {@link Places} or {@link Events} object but not both.

	 * @param message Message to attach to the checkin.
	 * @param photo New photo to attach as the primary photo for the checkin.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for the checkin.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param responseJsonDepth Nested object depth level counts in response json.

In order to reduce server API calls from an application, the JSON response may
include not just the objects that are being queried/searched, but also
important data related to the queried objects, such as the object's owner or
referencing objects.

Default depth is 1. Valid values are 1-8.

	 * @param tags Comma separated list of tags for this checkin.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the checkin on behalf of.

The current login user must be an application admin to create a checkin on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsCreate(String placeId, String eventId, String message, File photo, String photoId, Boolean prettyJson, Integer responseJsonDepth, String tags, String customFields, String aclName, String aclId, String suId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (placeId != null) formParams.put("place_id", placeId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (message != null) formParams.put("message", message);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (responseJsonDepth != null) formParams.put("response_json_depth", responseJsonDepth);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Posts objects.
	 * Deletes Posts objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Posts objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.           

Any {@link #photo primary photos} associated with the matched objects are not deleted.

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Posts objects to delete.
If not specified, all Posts objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show a Photo Collection
	 * Shows information about a collection including the cover photo, owner, parent
collection, and counts of its contents. See {@link PhotoCollections#show_subcollections Show
Subcollections} and {@link PhotoCollections#show_photos Show Photos} to view the contents
of a collection.

	 * 
	 * @param collectionId ID of the collection to retrieve photos from.
	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as the object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsShow(String collectionId, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'collectionId' is set
		if (collectionId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'collection_id' when calling photoCollectionsShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "collection_id", collectionId));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Query email templates
	 * 
	 * 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse emailTemplateEmailTemplatesQuery() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/email_templates/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * create
	 * Creates a scheduled push notification.  At minimum, you must specify the `start_time`,
and `payload` parameters. A push schedule can optionally define a location query so that
only devices in the specified geographic region will receive the push notification.

The current user must be an application admin to use this API.

	 * 
	 * @param schedule Push notification to schedule.
	 * @param where A JSON-encoded object that defines a location query used to select the devices
that will receive the scheduled notification. Up to 1000 users can be returned by the query. To specify a location query, set the `loc` field to a
[MongoDB Geospatial Query](http://docs.mongodb.org/manual/reference/operator/query-geospatial/).
The following query searches for all users within 2 km of Oakland, CA, USA:

    where={
      "loc": {
        "$nearSphere" : { 
          "$geometry" : { 
            "type" : "Point" , 
            "coordinates" : [-122.2708,37.8044] } , 
            "$maxDistance" : 2000 
          }
        }
      }

For details about using the `where` parameter, see the [Search and Query guide](#!/guide/search_query).

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushSchedulesCreate(String schedule, String where, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'schedule' is set
		if (schedule == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'schedule' when calling pushSchedulesCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_schedule/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (schedule != null) formParams.put("schedule", schedule);
		if (where != null) formParams.put("where", where);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a File
	 * Deletes the file. To delete a file, the current user must be one of the following:

*   The file's owner
*   A user with write priviledges granted by the file's ACL
*   An application admin

	 * 
	 * @param fileId ID of the file to delete.
	 * @param suId User to delete the File object on behalf of. The user must be the creator of the object.

The current user must be an application admin to delete the File object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesDelete(String fileId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'fileId' is set
		if (fileId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'file_id' when calling filesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (fileId != null) formParams.put("file_id", fileId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query of Geofences
	 * Perform custom query of geofences with sorting and paginating.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param responseJsonDepth Nested object depth level for response data.

Default is 1, valid range is 1 to 8.

Response data may include references to other objects, which the server performs
additional queries on to include in the response. To reduce server response time,
set this parameter to a lower value to reduce server API calls.

	 * @param where A JSON-encoded object that defines the query used.

The following fields can be used for the query:

  * {@link GeoFences#start_time}
  * {@link GeoFences#end_time}
  * `loc` : For this property, specify a
    [MongoDB Geospatial Query](http://docs.mongodb.org/manual/reference/operator/query-geospatial/).

If `where` is not specified, `query` returns all objects.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject geoFencesQuery(Integer page, Integer perPage, Integer limit, Integer skip, Integer responseJsonDepth, String where, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/geo_fences/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Place objects.
	 * Retrieves the total number of Place objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Creates a Geofence.
	 * Creates a geo-fence object with an optional start and end time.

	 * 
	 * @param geoFence JSON object describing the geographic perimeter, data payload, and start and end time
for the geo-fence object.  Specify the following propertes:

  * `loc` (Hash): **Required.** Geographic perimeter.  See {@link GeoFences#loc}.
  * `payload` (Hash): **Required.** JSON-encoded data to retrieve if a device intersects
    the geographic perimeter.
  * `start_time` (Date): Datetime to start the geo-fence.
  * `end_time` (Date): Datetime to end the geo-fence.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject geoFencesCreate(String geoFence, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'geoFence' is set
		if (geoFence == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'geo_fence' when calling geoFencesCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/geo_fences/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (geoFence != null) formParams.put("geo_fence", geoFence);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 *  Delete an email template
	 * 
	 * 
	 * @param emailTemplateId Email template id.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse emailTemplateEmailTemplatesDelete(String emailTemplateId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'emailTemplateId' is set
		if (emailTemplateId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'email_template_id' when calling emailTemplateEmailTemplatesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/email_templates/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (emailTemplateId != null) formParams.put("email_template_id", emailTemplateId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Query Custom Objects
	 * Query custom object by specified fields with sorting and paginating. 

**Notes**:

* If a custom object contains fields or values that are greater than 1KB in length, you will
not be able to query on that field. For more information, see [Indexing Size Limit for Custom Objects and Fields](#!/guide/customfields-section-indexing-size-limit-for-custom-objects-and-fields).
* Currently, you cannot query or sort data stored inside an array or hash.
* You can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param showUserLike If set to **true**, each CustomObject in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the current user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param where Constraint values for fields. `where` should be encoded JSON.

Each value in the search query needs to be less that 1024 bytes.
If the value is larger than 1024 bytes, the query does not return any results.

In addition to developer created fields, custom objects include
four predefined fields that can be queried as well:

*   `user_id: String`.  Object owner's user ID.

*   `tags_array: String`. List of tags.

*   `created_at: Date`. Timestamp when the object was created.

*   `updated_at: Date`. Timestamp when the object was updated.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields, specified as a comma-separated list of
field names.
See the [Search and Query guide](#!/guide/search_query) for more information.

Fields with a Hash data type cannot be sorted. Custom objects include
two predefined sortable fields:

    `created_at: Date` - Timestamp when the object was created.
    `updated_at: Date` - Timestamp when the object was last updated.

For example, if you want to query cars and sort them by `make` and
`created_at`:

    "order": "make,created_at"

To reverse the sorting order, simply add `-` in front of a field. For example,
to sort results by `make` in ascending order then by `created_at` in descending
order:

    "order": "make,-created_at"

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsQuery(String classname, Integer page, Integer perPage, Integer limit, Integer skip, Boolean prettyJson, Boolean showUserLike, String where, String order, String sel, String unsel, Integer responseJsonDepth) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsQuery");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/query.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Set a windows push settings on an app.
	 * 
	 * 
	 * @param wnsSid 
	 * @param wnsClientSecret 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsSetWindowsCertificate(String wnsSid, String wnsClientSecret) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/set_windows_certificate.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (wnsSid != null) formParams.put("wns_sid", wnsSid);
		if (wnsClientSecret != null) formParams.put("wns_client_secret", wnsClientSecret);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Delete Custom Object
	 * Only the owner of the object or user who is granted write permission by the
object's ACL can delete the object.

The {@link #photo primary photo} associated with the CustomObject is not deleted.

An application admin can delete any custom object.

	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @param iD The object ID of the custom object to delete.

You must specify either `id` or `ids`.

	 * @param ids A comma-separated list of object IDs of the custom objects to delete.

You must specify either `id` or `ids`.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param suId User to delete the Custom object on behalf of. The user must be the creator of the object.

The current user must be an application admin to delete a Custom object on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsDelete(String classname, String iD, String ids, Boolean prettyJson, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsDelete");
		}
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling customObjectsDelete");
		}
		// verify the required parameter 'ids' is set
		if (ids == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'ids' when calling customObjectsDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/delete.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (ids != null) formParams.put("ids", ids);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create (Upload) a Photo
	 * Create a photo using the given `photo` binary attachment. A `collection_name`
or `collection_id` is optional. The response includes a `processed` flag which
indicates if the photo has been resized and stored reliably in the
ArrowDB storage engine. This will initially be `false`.
The `md5` field gives the md5 sum of the file which can be used to verify file
integrity.

	 * 
	 * @param photo The attached binary file.

	 * @param title Photo title.
	 * @param collectionName Name of the {@link PhotoCollections} to add this photo to.
	 * @param collectionId ID of the {@link PhotoCollections} to add this photo to.
	 * @param tags Comma separated list of tags to associate with this photo.

	 * @param customFields User-defined fields to add to this photo. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this photo object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this photo object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the photo on behalf of.

The current login user must be an application admin to create a photo on
behalf of another user.

	 * @param photoSizes User-defined photo sizes. See [Photo Uploading &
Sizes](#!/guide/photosizes#custom).  Sizes be specified as a JSON object, or using a separate parameter for each
size. To specify a photo size called "preview" using JSON:

    photo_size : { "preview" : "120x120#" }

To pass each size as a separate parameter, do *not* use the literal parameter name `photo_sizes`,
but add a parameter named `photo_sizes[`_sizeName_`]` for each custom photo
size. The previous example in this format looks like this:

    "photo_size[preview]" : "120x120#"

	 * @param photoSyncSizes Synchronous photo sizes to upload. See [Photo Uploading & Resizing](#!/guide/photosizes).

The literal name for this parameter is `photo_sync_sizes[]`. This parameter can be specified
multiple times, once for each photo size that must be created before the request returns.

For example:

    "photo_sync_sizes[]=preview"

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosCreate(File photo, String title, String collectionName, String collectionId, String tags, String customFields, String aclName, String aclId, String suId, String photoSizes, String photoSyncSizes, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'photo' is set
		if (photo == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'photo' when calling photosCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (photo != null) formParams.put("photo", photo);
		if (title != null) formParams.put("title", title);
		if (collectionName != null) formParams.put("collection_name", collectionName);
		if (collectionId != null) formParams.put("collection_id", collectionId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (photoSizes != null) formParams.put("photo_sizes", photoSizes);
		if (photoSyncSizes != null) formParams.put("photo_sync_sizes[]", photoSyncSizes);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Reviews objects.
	 * Deletes Reviews objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Reviews objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.              

The reviewed object ({@link #post Post}, {@link #photo Photo}, {@link #user User}, {@link #event Event}, 
{@link #checkin Checkin}, {@link #place Place}, {@link #custom_object CustomObject}, 
{@link #status Status}, or {@link #review Review}) of each matched object is not deleted.

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Reviews objects to delete.
If not specified, all Reviews objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Updates a Geofence
	 * Updates an existing geo-fence object.

	 * 
	 * @param iD ID of the geo-fence object to update.
	 * @param geoFence JSON object describing the geographic perimeter, data payload, and start and end time
for the geo-fence object.  Specify the following propertes:

  * `loc` (Hash): **Required.** Geographic perimeter.  See {@link GeoFences#loc}.
  * `payload` (Hash): JSON-encoded data to retrieve if a device intersects the geographic
    perimeter.
  * `start_time` (Date): Datetime to start the geo-fence.
  * `end_time` (Date): Datetime to end the geo-fence.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject geoFencesUpdate(String iD, String geoFence, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling geoFencesUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/geo_fences/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (geoFence != null) formParams.put("geo_fence", geoFence);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Search Friends
	 * Performs a search for users who are friends of the currently logged-in user. An application admin
can search for friends of an arbitrary user by specifing the the `user_id` field.

Specifying the optional `q` parameter allows searching by first name, last name, email address,
or username. If no `q` parameter is specified, all friends of the specified user are returned.

If one-way friendship is enabled, the search returns the users being followed. To return
the user's followers, set the `followers` field to true.

	 * 
	 * @param userId ID of the user to search for friends. **You must be an application admin to use this field.**

If friendship is set to one way,
by default it searches against users that the identified user is **following**. You can
pass `followers=true` to search the user's followers.

	 * @param followers If you have friends set to one way, pass `followers=true` to query user's
followers.

	 * @param q Space-separated list of keywords used to perform full text search on first name, last name,
email address, username and tags.

	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject friendsSearch(String userId, Boolean followers, String q, Integer page, Integer perPage, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/friends/search.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "followers", followers));
		queryParams.addAll(client.parameterToPairs("", "q", q));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * notify_tokens
	 * Sends push notifications to one or more users who are subscribed to a channel.

Application admins can set the `to_tokens` parameter to `everyone` to send to all devices
subscribed to the identified channel.

If you use the `to_tokens` parameter, you **cannot** specify a location query using the `where`
parameter in the same API call.

	 * 
	 * @param channel Name of the channel. For multiple channels, either comma-separate the list of channels
or use an array of strings.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param toTokens Comma-separated list of device tokens. Sends push notification to the specified
tokens who are subscribed to the specified channel.

You **cannot** use this parameter with a location query using the `where` parameter.

Application admins can set this parameter to `everyone` to send to all devices
subscribed to the channel.

If you are using the web interface, you do not need to specify this parameter.

	 * @param payload Payload to send with the push notification.

For a string, it will be sent as an alert (message notification).

	 * @param options Additional push options.

* *expire_after_seconds* (Number): Expiration time in seconds of when to stop sending the push notification.
  For example, if the push notification expiration time is for a day and the user's device
  is off for over a day, the user does not receive the push notification since it has expired.

For example, to specify a one day expiration period, use `options={'expire_after_seconds':86400}`.

	 * @param where A JSON-encoded object that defines either the user or location query used to select the device
that will receive the notification. Up to 1000 users can be returned by the query.

If you are using the `to_tokens` parameter, you **cannot** specify a location query.

To specify a user query, set the `user` field to a custom query, for example, the
following query searches for all users with the first name of Joe:

    where={"user": {"first_name":"Joe">

To specify a location query, set the `loc` field to a
[MongoDB Geospatial Query](http://docs.mongodb.org/manual/reference/operator/query-geospatial/).
The following query searches for all users within 2 km of Oakland, CA, USA:

    where={"loc": { "$nearSphere" : { "$geometry" : { "type" : "Point" , "coordinates" : [-122.2708,37.8044] } , "$maxDistance" : 2000 >}

For details about using the `where` parameter,
see the [Search and Query guide](#!/guide/search_query).

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsNotifyTokens(String channel, String toTokens, String payload, String options, String where, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'channel' is set
		if (channel == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'channel' when calling pushNotificationsNotifyTokens");
		}
		// verify the required parameter 'toTokens' is set
		if (toTokens == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'to_tokens' when calling pushNotificationsNotifyTokens");
		}
		// verify the required parameter 'payload' is set
		if (payload == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'payload' when calling pushNotificationsNotifyTokens");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/notify_tokens.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (channel != null) formParams.put("channel", channel);
		if (toTokens != null) formParams.put("to_tokens", toTokens);
		if (payload != null) formParams.put("payload", payload);
		if (options != null) formParams.put("options", options);
		if (where != null) formParams.put("where", where);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Set a string or binary value
	 * Sets a string or binary value referenced by the key name. The size of the
value can be up to 2M, and the key name length can be up to 256 characters.
The default value type is String.

	 * 
	 * @param name The name, or key, for this key-value pair.
	 * @param type Value type: "string" or "binary".

Defaults to "string".

	 * @param value Value to assoicate with the key.

Binary data can be passed as a binary form part. The REST example shows how to
send binary data using curl.

	 * @param accessPrivate Determines whether this key-value is publically readable, or stored in a
private store.

Default is false (publically readable). If set to true, it sets the key/value stored
in the current user's private key-value store. Otherwise, it sets the public
key-value pair which is readable to everyone.

	 * @param suId User to create the key-value pair on behalf of.

The current user must be an application admin to set a key-value pair on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesSet(String name, String type, String value, Boolean accessPrivate, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling keyValuesSet");
		}
		// verify the required parameter 'value' is set
		if (value == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'value' when calling keyValuesSet");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/set.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (type != null) formParams.put("type", type);
		if (value != null) formParams.put("value", value);
		if (accessPrivate != null) formParams.put("access_private", accessPrivate);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete an app or apps.
	 * 
	 * 
	 * @param groupId Note that it should take either group_id or app_id, not both.
	 * @param appId Note that it should take either group_id or app_id, not both.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsDelete(String groupId, String appId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (groupId != null) formParams.put("group_id", groupId);
		if (appId != null) formParams.put("app_id", appId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Delete a Place
	 * Deletes a place.

Only the user who created the place can delete it.

The {@link #photo primary photo} associated with the object is not deleted.

An application admin can delete any Place object.

	 * 
	 * @param placeId ID of the place to delete.
	 * @param suId User ID to delete the Place object on behalf of. The user must be the creator of the object.

The current login user must be an application admin to delete a Place object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesDelete(String placeId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'placeId' is set
		if (placeId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'place_id' when calling placesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (placeId != null) formParams.put("place_id", placeId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show an ACL
	 * Shows the ACL object with the given `id` or `name`.

	 * 
	 * @param iD ID of the ACL oject.

Either `name` or `id` must be specified.

	 * @param name Name of the ACL object.

Either `name` or `id` must be specified.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsShow(String iD, String name, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "id", iD));
		queryParams.addAll(client.parameterToPairs("", "name", name));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete an app data.
	 * 
	 * 
	 * @param appId App id.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsDeleteData(String appId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/delete/data.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (appId != null) formParams.put("app_id", appId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Get a Value
	 * Gets the value of a key-value pair.

If the value is string, the KeyValue object is returned in JSON format. If the value is
binary, the value is returned directly **without** a JSON wrapper and the content type
is set to "application/octct-stream".

	 * 
	 * @param name Name (or key) for the key-value pair to retrieve.
	 * @param accessPrivate Determines whether to retrieve this key-value from the publically readable store
or from the user's private store.

Default is false (publically readable).

	 * @param userId Retrieve a private key-value pair from the identified user's store.

Login user must be an application admin to retrieve a key-value from another
user's store.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesGet(String name, Boolean accessPrivate, String userId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling keyValuesGet");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/get.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "name", name));
		queryParams.addAll(client.parameterToPairs("", "access_private", accessPrivate));
		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update an ACL
	 * Updates an ACL object to change its access control list. When updating an ACL,
you can change the members of the `readers` list and the `writers` list, or change the value
of the `public_read` and `public_write` flags.

An application admin can update any ACL object.

	 * 
	 * @param iD ID of the ACL oject.

Either `name` or `id` must be specified.

	 * @param name Name of the ACL object.

Either `name` or `id` must be specified.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param readerIds Comma separated list of IDs identifying users who can read objects
controlled by this ACL.

To remove all users from the `readers` list, simply set `reader_ids=""`.
This removes all users except for the owner from the list.

	 * @param writerIds Comma separated list of IDs identifying users who can update an object.
controlled by this ACL.

To remove all users from the `writers` list, simply set `writer_ids=""`.
This removes all users except for the owner from the list.

	 * @param publicRead Determines whether objects controlled by this ArrowDB are publically readable.

Default is false.

	 * @param publicWrite Determines whether objects controlled by this ArrowDB are publically writable.

Default is false.

	 * @param suId User to update the ACL object on behalf of. The user must be the creator of the object.

The current user must be an application admin to update an ACL object on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsUpdate(String iD, String name, Boolean prettyJson, String readerIds, String writerIds, String publicRead, String publicWrite, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'readerIds' is set
		if (readerIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'reader_ids' when calling aCLsUpdate");
		}
		// verify the required parameter 'writerIds' is set
		if (writerIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'writer_ids' when calling aCLsUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (name != null) formParams.put("name", name);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (readerIds != null) formParams.put("reader_ids", readerIds);
		if (writerIds != null) formParams.put("writer_ids", writerIds);
		if (publicRead != null) formParams.put("public_read", publicRead);
		if (publicWrite != null) formParams.put("public_write", publicWrite);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Photo objects.
	 * Retrieves the total number of Photo objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Delete the message with the given `id`. The message must be in the current
user's inbox or sent mail. There is currently no trash folder and deletion is
permanent.

Application Admin can delete any Message object.

	 * 
	 * @param messageId ID of the message to delete.
	 * @param suId User to delete the Message object on behalf of. The user needs to be either the sender
or recipient of the message.

The current user must be an application admin to delete a Message object on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesDelete(String messageId, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'messageId' is set
		if (messageId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'message_id' when calling messagesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (messageId != null) formParams.put("message_id", messageId);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update a Photo
	 * Updates the photo attachment, the collection that the photo belongs to, or
other photo properties. When replacing the existing photo attachment with a
new one, `processing` will be set to `false`. However the existig URLs will
remain valid until the new photo has been processed and uploaded to the
Appcelerator Cloud Services storage cloud. At this time, the old URLs will be
replaced with the URLs of the newly processed photo.

An application admin can update any Photo object.

	 * 
	 * @param photoId ID of the photo to update.
	 * @param photo New photo to associate with this object, attached as a binary file.

	 * @param title Photo title.
	 * @param collectionName Name of the {@link PhotoCollections} to add this photo to. Replaces the
existing collection, if any.

	 * @param collectionId ID of the {@link PhotoCollections} to add this photo to. Replaces the existing
collection, if any.

	 * @param tags Comma separated list of tags to associate with this photo. Overwrites any
existing tags.

	 * @param customFields User-defined fields to add to this photo. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this photo object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

To delete an ACL, set `acl_name` or `acl_id` to the empty string.

	 * @param aclId ID of an {@link ACLs} to associate with this photo object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param photoSizes User-defined photo sizes. See [Photo Uploading & Resizings](#!/guide/photosizes).
Sizes be specified as a JSON object, or using a separate parameter for each
size. To specify a photo size called "preview" using JSON:

    photo_size : { "preview" : "120x120#" }

To pass each size as a separate parameter, do *not* use the literal parameter name `photo_sizes`,
but add a parameter named `photo_sizes[`_sizeName_`]` for each custom photo
size. The previous example in this format looks like this:

    "photo_size[preview]" : "120x120#"

	 * @param photoSyncSizes Synchronous photo sizes to upload. See [Photo Uploading & Resizings](#!/guide/photosizes).

The literal name for this parameter is `photo_sync_sizes[]`. This parameter can be specified
multiple times, once for each photo size that must be created before the request returns.

For example:

    "photo_sync_sizes[]=preview"

	 * @param suId User ID to update the Photo object on behalf of. The user must be the creator of the object.

The current login user must be an application admin to update a Photo object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosUpdate(String photoId, File photo, String title, String collectionName, String collectionId, String tags, String customFields, String aclName, String aclId, String photoSizes, String photoSyncSizes, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'photoId' is set
		if (photoId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'photo_id' when calling photosUpdate");
		}
		// verify the required parameter 'photo' is set
		if (photo == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'photo' when calling photosUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (photoId != null) formParams.put("photo_id", photoId);
		if (photo != null) formParams.put("photo", photo);
		if (title != null) formParams.put("title", title);
		if (collectionName != null) formParams.put("collection_name", collectionName);
		if (collectionId != null) formParams.put("collection_id", collectionId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (photoSizes != null) formParams.put("photo_sizes", photoSizes);
		if (photoSyncSizes != null) formParams.put("photo_sync_sizes", photoSyncSizes);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Like
	 * Delete the like from the target object. Only the original submitter can delete
the like.

Specify one and only one of the ID parameters to identify  the target object.

	 * 
	 * @param postId Post object to delete "like" from.
	 * @param photoId Photo object to delete "like" from.
	 * @param userId User object to delete "like" from.
	 * @param eventId Event object to delete "like" from.
	 * @param placeId Place object to delete "like" from.
	 * @param checkinId Checkin object to delete "like" from.
	 * @param statusId Status object to delete "like" from.
	 * @param reviewId Review object to delete "like" from.
	 * @param customObjectId Custom object to delete "like" from.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject likesDelete(String postId, String photoId, String userId, String eventId, String placeId, String checkinId, String statusId, String reviewId, String customObjectId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/likes/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (postId != null) formParams.put("post_id", postId);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (userId != null) formParams.put("user_id", userId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (placeId != null) formParams.put("place_id", placeId);
		if (checkinId != null) formParams.put("checkin_id", checkinId);
		if (statusId != null) formParams.put("status_id", statusId);
		if (reviewId != null) formParams.put("review_id", reviewId);
		if (customObjectId != null) formParams.put("custom_object_id", customObjectId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create Custom Object
	 * Create a custom object of type `classname`.

The `classname` of the object is part of the URL. You do not have to define
`classname` ahead of time. It will be created on the fly

	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @param fields JSON encoding of object fields. You don't have to define fields ahead of time,
simply set key-value pairs of the fields. Since the data must be encoded as
JSON, keys must not contain the dot character.

For instance, if you want to define a car object:

    {
       "make": "nissan",
       "color": "blue",
       "year": 2005,
       "purchased_at": "2011-11-02 17:07:37 -0700",
       "used": false
    }

See the main description for {@link CustomObjects} for more information on
fields.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param tags Comma-separated list of tags associated with this object.

If the `tags` parameter is omitted and a `tags` key is included in the
`fields` dictionary, `fields.tags` will be used instead.

	 * @param photo New photo to attach as the primary photo for the object.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for the object.

	 * @param aclName Name of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the object on behalf of.

The current login user must be an application admin to create an object on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsCreate(String classname, String fields, Boolean prettyJson, String tags, File photo, String photoId, String aclName, String aclId, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsCreate");
		}
		// verify the required parameter 'fields' is set
		if (fields == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'fields' when calling customObjectsCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/create.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (fields != null) formParams.put("fields", fields);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (tags != null) formParams.put("tags", tags);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Chat.
	 * Deletes a chat message.

	 * 
	 * @param chatId ID of the chat message to delete.
	 * @param suId User to delete the Chat object on behalf of. The user must be the sender of the chat
message.

Current user must be an application admin to send a message on behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject chatsDelete(String chatId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'chatId' is set
		if (chatId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'chat_id' when calling chatsDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/chats/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (chatId != null) formParams.put("chat_id", chatId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Event Occurrences
	 * Show the event occurrences of an event with the given `event_id`.

	 * 
	 * @param eventId ID of the event to show occurrences of.
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsShowOccurrences(String eventId, Integer page, Integer perPage, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'eventId' is set
		if (eventId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'event_id' when calling eventsShowOccurrences");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/show/occurrences.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "event_id", eventId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Shows the first message in each of the most recent threads in the user's inbox.
	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesShowThreads(Integer page, Integer perPage) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/show/threads.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show a Checkin
	 * Returns the contents of the identified checkin.
	 * 
	 * @param checkinId ID of the checkin to show.
	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

	 * @param showUserLike If set to **true** the Checkin object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsShow(String checkinId, Integer responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'checkinId' is set
		if (checkinId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'checkin_id' when calling checkinsShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "checkin_id", checkinId));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete an ACL
	 * Deletes an ACL object with the given `id` or `name`.

An application admin can delete any ACL object.

	 * 
	 * @param iD ID of the ACL oject to delete.

Either `name` or `id` must be specified.

	 * @param name Name of the ACL object to delete.

Either `name` or `id` must be specified.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param suId User to delete the ACL object on behalf of. The user must be the creator of the object.

The current user must be an application admin to remove an ACL on
behalf of another user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsDelete(String iD, String name, Boolean prettyJson, String suId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (name != null) formParams.put("name", name);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of devices subscribed to push notifications.
	 * Retrieves the total number of devices subscribed to push notifications.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create Review&#x2F;Comment&#x2F;Rating&#x2F;Like
	 * Adds a review with an optional integer rating. You can also use this API to add
comments or likes.

Once an object has one or more reviews (comments) attached to it, it will
return a total review count, rating_count, average rating and a breakdown of
each rating value:

    "reviews_count": 2,
    "ratings_count": 2,
    "ratings_average": 150.0,
    "ratings_summary": {
      "100": 1,
      "200": 1
    },

To create a review, you must specify a target object using one of the `<object>_id` parameters, 
such as `photo_id` or `post_id`. Only one `<object>_id` parameter may be specified in a request.
To specify a {@link Users User} to review, use the the `user_object_id` parameter.

An application admin can create a review on behalf of another user by 
specifying that user's ID in the `user_id` method parameter. 

A review must include either `content` or `rating`. It can also include both.

	 * 
	 * @param postId ID of the {@link Posts} object to review.

	 * @param photoId ID of the {@link Photos} object to review.

	 * @param userObjectId ID of the {@link Users} object to review.

	 * @param eventId ID of the {@link Events} object to review.

	 * @param placeId ID of the {@link Places} object to review.

	 * @param checkinId ID of the {@link Checkins} object to review.

	 * @param reviewId ID of the {@link Reviews} object to review.

	 * @param customObjectId ID of the {@link CustomObjects} object to review.

	 * @param statusId ID of the {@link Statuses} object to review.

	 * @param content Review or comment text.

	 * @param rating Rating to be associated with review. You can use "1" to represent one {@link Likes Like}.
	 * @param allowDuplicate By default, the same user can only submit one review/comment per object.
Set this flag to `true` to allow the user to add multiple  reviews or comments to
the same object.

	 * @param tags Comma separated list of tags for this review.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId ID of the {@link Users} object to create the review on behalf of.

The currently logged-in user must be an application admin to create a review on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsCreate(String postId, String photoId, String userObjectId, String eventId, String placeId, String checkinId, String reviewId, String customObjectId, String statusId, String content, String rating, Boolean allowDuplicate, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (postId != null) formParams.put("post_id", postId);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (userObjectId != null) formParams.put("user_object_id", userObjectId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (placeId != null) formParams.put("place_id", placeId);
		if (checkinId != null) formParams.put("checkin_id", checkinId);
		if (reviewId != null) formParams.put("review_id", reviewId);
		if (customObjectId != null) formParams.put("custom_object_id", customObjectId);
		if (statusId != null) formParams.put("status_id", statusId);
		if (content != null) formParams.put("content", content);
		if (rating != null) formParams.put("rating", rating);
		if (allowDuplicate != null) formParams.put("allow_duplicate", allowDuplicate);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Check the status of ArrowDB
	 * 
	 * 
	 * @param ct If the app is enterprise.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse systemPing(String ct) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/admins/ping.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "ct", ct));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Send a reset password email to User
	 * Sends an email to a user containing a link to recover a lost password. You can use the default
email template provided by ACS, or specify a [custom email template](http://docs.appcelerator.com/platform/latest/#!/guide/Managing_Email_Templates-section-37548619_ManagingEmailTemplates-Creatinganemailtemplate) 
that you have created. When using a custom email template, the email must contain a properly
formatted URL, as explained in the `template` method parameter documentation below.

You must also have configured your application's [email settings](http://docs.appcelerator.com/platform/latest/#!/guide/Configuring_Cloud_Services-section-39683049_ConfiguringCloudServices-Email) 
in Appcelerator Dashboard.

	 * 
	 * @param email Email address. Must match the user's registered email address.
	 * @param subject The default subject of the password reset email is "Password reset request for
<your app name>". If you wish to have your custom email subject, you can
provide it by setting the subject parameter

	 * @param template If you wish to use your custom email body. You can create a email template and
pass the template name. The email must contain a properly formatted link to the password
reset URL on appcelerator.com, or a link on your own site, as follows:
<p>

To link directly to the password page, your email template must contain a link to the following
URL:

    https://dashboard.appcelerator.com/#/users/confirmation/<key>/<confirmation_token>

If you prefer the user to reset their password on your own website, rather than on appcelerator.com,
you must provide a URL with the following format:

    https://[your_url.com]/[your_method]?reset_password_token=<reset_password_token>

This page must cache the value of the `reset_password_token` parameter and present a form 
that allows the user to enter a new password and password confirmation.
When the user submits the form, the app server must make the following call to Appcelerator Cloud Services API to reset the
password, passing the original password reset token, the user's new password, and the password confirmation:

    GET https://api.cloud.appcelerator.com/v1/users/reset_password.json?key=<Your App Key>&reset_password_token=<reset_password_token>&password=<password> &password_confirmation=<password_confirmation>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersRequestResetPassword(String email, String subject, String template, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'email' is set
		if (email == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'email' when calling usersRequestResetPassword");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/request_reset_password.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "email", email));
		queryParams.addAll(client.parameterToPairs("", "subject", subject));
		queryParams.addAll(client.parameterToPairs("", "template", template));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Status
	 * Deletes a status for the currenty logged in user.
The associated {@link #event Event}, {@link #photo Photo}, or {@link #place Place} is not deleted.

	 * 
	 * @param statusId ID of the status to delete.
	 * @param suId User ID to destroy the status on behalf of.

The current login user must be an application admin to destroy a status on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesDelete(String statusId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'statusId' is set
		if (statusId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'status_id' when calling statusesDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (statusId != null) formParams.put("status_id", statusId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Creates a user.
	 * Creates a new user.

When creating a user, you must specify either:

*   username
*   email address, first name, and last name

A user can have both an email address and username specified. However, if username
is omitted, email address, first name and last name are required.

For regular users (non-admin users), after successully executing this command, you will be logged
in as the new user and the session ID will be associated with the newly created user.  For
example, when user A creates user B, user A is now logged in as user B and user A's session
ID belongs to user B.

For admin users, you will still be logged in as the admin user.

	 * 
	 * @param email User's email address. Required if `username` is not specified.
	 * @param username User's login name. Required if `email` is not specified.

If `username` is not specified, `email`, `first_name`, and `last_name` must be included.

	 * @param password User's password.
	 * @param passwordConfirmation Copy of user's password for confirmation.
	 * @param firstName User's first name. Required when `username` is not provided.
	 * @param lastName User's last name. Required when `username` is not provided.
	 * @param photo New photo to attach as the primary photo for the user.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for the user.

	 * @param tags Comma separated list of tags for this user.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create this user on behalf of.

The current login user must be an application admin to create a user on
behalf of another user.

	 * @param role String representation of user role, for example, "teacher".
	 * @param template Send a congratulation email to notify that the user has been created successfully.

You need to create an email template and pass the template name.

	 * @param confirmationTemplate If "New User Email Verification" is enabled for the application, ArrowDB sends a confirmation email to
the user.

If you don't pass the `confirmation_template` parameter, then ArrowDB sends a default
confirmation email.

If you wish to use your custom email body, you can create a email template and pass
the template name. Your email template must contain the following URL to allow users
to be redirected to Appcelerator Cloud Services email verification page:

     https://cloud.appcelerator.com/users/confirmation?key=<key>&confirmation_token=<confirmation_token>

If you have your own website that talks to Appcelerator Cloud Services backend and
wish to use custom URL, you must provide a URL with the following format:

     https://<your_url.com>/<your_method>?key=<key>&confirmation_token=<confirmation_token>

When a user visits the above URL, you call the ArrowDB `users/confirm_user.json` method to 
confirm the user internally from your web server and you must append the query parameter `&ct=enterprise`
to the end of the URL:

     GET https://api.cloud.appcelerator.com/v1/users/confirm_user.json?confirmation_token=<confirmation_token>&key=<Your App Key>&ct=enterprise

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersCreate(String email, String username, String password, String passwordConfirmation, String firstName, String lastName, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, String role, String template, String confirmationTemplate, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'password' is set
		if (password == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'password' when calling usersCreate");
		}
		// verify the required parameter 'passwordConfirmation' is set
		if (passwordConfirmation == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'password_confirmation' when calling usersCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (email != null) formParams.put("email", email);
		if (username != null) formParams.put("username", username);
		if (password != null) formParams.put("password", password);
		if (passwordConfirmation != null) formParams.put("password_confirmation", passwordConfirmation);
		if (firstName != null) formParams.put("first_name", firstName);
		if (lastName != null) formParams.put("last_name", lastName);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (role != null) formParams.put("role", role);
		if (template != null) formParams.put("template", template);
		if (confirmationTemplate != null) formParams.put("confirmation_template", confirmationTemplate);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of User objects.
	 * Retrieves the total number of User objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Search Photo Collections
	 * Search for top-level collections owned by the given user. Subcollections cannot
be found this way. See {@link PhotoCollections#show_subcollections Show Subcollections} to view the
subcollections of a collection.

	 * 
	 * @param userId ID of the user to find collections for.
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as object's owner and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsSearch(String userId, Integer page, Integer perPage, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'userId' is set
		if (userId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'user_id' when calling photoCollectionsSearch");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/search.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Channels Query
	 * Returns a list of push notification channels the user is subscribed to.

For application admins, if the `user_id` parameter is not specified, returns all channels
with subscribed users.

	 * 
	 * @param userId User to retrieve subscribed channels for.

Only application admins can query subscribed channels of a user.

	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param count Set to `true` to return the total number of push channels in the `count` field of the
`meta` header.  Default is `false`.

Only valid for applications created with ArrowDB 1.1.8 or greater.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsChannelsQuery(String userId, Integer page, Integer perPage, Boolean prettyJson, Boolean count) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/channels/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "count", count));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Show messages with the given `thread_id` from the user's inbox. If the status
of any of the returned messages is `unread`, it will be changed to `read`.

	 * 
	 * @param threadId ID of the thread to show messages from.
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesShowThread(String threadId, Integer page, Integer perPage) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/show/thread.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "thread_id", threadId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Set SMTP or MessageGears settings for an app, app email will be delivered through SMTP or MessageGears.
	 * 
	 * 
	 * @param address SMTP server Address.
	 * @param username SMTP username.
	 * @param password SMTP password.
	 * @param tls SMTP TLS support.
	 * @param port SMTP server port.
	 * @param authentication SMTP: Valid valud is Plain, Login or MD5.
	 * @param domain SMTP: Domain.
	 * @param provider Email provider, it 's "smtp" by default if not provided.
	 * @param accountid App key.
	 * @param apikey App key.
	 * @param endpoint App key.
	 * @param senderEmail MessageGears: It's required by MessageGears, should be a valid email address, such as "acs_support@appcelerator.com".
	 * @param senderName MessageGears: Such as "Appcelerator Cloud Service Support Team".
	 * @param devMode 
	 * @param replacementEmail Default Sender Email.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsEmailsSetting(String accountid, String apikey, String endpoint, String senderEmail, String senderName, String address, String username, String password, Boolean tls, String port, String authentication, String domain, String provider, Boolean devMode, String replacementEmail) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/emails/setting.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "accountid", accountid));
		queryParams.addAll(client.parameterToPairs("", "apikey", apikey));
		queryParams.addAll(client.parameterToPairs("", "endpoint", endpoint));
		queryParams.addAll(client.parameterToPairs("", "sender_email", senderEmail));
		queryParams.addAll(client.parameterToPairs("", "sender_name", senderName));


		if (address != null) formParams.put("address", address);
		if (username != null) formParams.put("username", username);
		if (password != null) formParams.put("password", password);
		if (tls != null) formParams.put("tls", tls);
		if (port != null) formParams.put("port", port);
		if (authentication != null) formParams.put("authentication", authentication);
		if (domain != null) formParams.put("domain", domain);
		if (provider != null) formParams.put("provider", provider);
		if (devMode != null) formParams.put("dev_mode", devMode);
		if (replacementEmail != null) formParams.put("replacement_email", replacementEmail);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Create a Photo Collection
	 * Collections contain one or more photos and/or sub-collections. These can be
used as photo albums for a user. To create a subcollection,
specify a `parent_collection_id` when creating a collection. If the collection has been
created or updated with a `cover_photo_id`, photo details will be returned
with collection information. If a `cover_photo_id` has not been assigned, the
first photo found in the collection or its sub-collections will be returned as
the cover photo.

	 * 
	 * @param name Name of the collection. The name must be unique across other top-level
collections. If this is a sub-collection, the name must be unique across other
sub-collections of the same parent.

	 * @param parentCollectionId Parent collection ID. Specify when creating a subcollection.

	 * @param coverPhotoId ID of the photo to use as a cover photo. The photo does not need to be
in the collection.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this collection.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this collection.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the collection on behalf of.

The current login user must be an application admin to create a collection on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsCreate(String name, String parentCollectionId, String coverPhotoId, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (parentCollectionId != null) formParams.put("parent_collection_id", parentCollectionId);
		if (coverPhotoId != null) formParams.put("cover_photo_id", coverPhotoId);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple CustomObject objects.
	 * Deletes CustomObjects objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all CustomObject objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.  

The matched objects are deleted asynchronously in a separate process. 

The {@link #photo primary photos} associated with the matched objects are not deleted. 

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for CustomObjects objects to delete.
If not specified, all CustomObjects objects are deleted.

	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsBatchDelete(String classname, String where) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsBatchDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/batch_delete.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Event objects.
	 * Retrieves the total number of Event objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of PhotoCollection objects.
	 * Retrieves the total number of PhotoCollection objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Photos objects.
	 * Deletes Photos objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Photos objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.                

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Photos objects to delete.
If not specified, all Photos objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Update the event with the given `id`. Only the original submitter can update
the event.

For the event that is set as a recurring event, once created, there will be
several "event occurrences" created associating with the event object on
server side, one "event occurrence" represents a single occurrence of the
recurring event. An "event occurrence" contains start and end time of the
event's occurrence which are calulated according to the "recurring" settings
of the event object.

Instead of computing actual individual occurrences of a recurring event on the
client side, you can use event occurrences query API to get a list of
occurrences associated with a repeating event.

To get all "event occurrence" of an recurring event object, you can use
{@link Events#show_occurrences} with the event's `id`.

All the event occurrences will be recomputed if there is any change to the
start_time, duration and/or recurring.

An application admin can update any Event object.

	 * 
	 * @param eventId ID of the event to update.
	 * @param name Updated event name.
	 * @param startTime Updated event start time.
	 * @param duration Updated event duration, in seconds.
	 * @param recurring New recurrance schedule. Can take the following values: "daily", "weekly", "monthly", or "yearly".

	 * @param recurringCount Updated number of occurrences for the event.
	 * @param recurringUntil Updated date of last recurrance.
	 * @param details Updated description of the event.
	 * @param placeId ID of the place where this event takes place.
	 * @param photo New photo to assign as the event's primary photo.

When you use `photo` parameter to attach a new photo, you can use it with
[custom resize and sync options](/docs/photosizes)

To remove primary photo, simply set "photo=" or "photo_id=". If the original
photo was created by using `photo` parameter, the photo will be deleted.

	 * @param photoId ID of an existing photo to use as the event's primary photo.

To remove primary photo, simply set "photo=" or "photo_id=". If the original
photo was created by using `photo` parameter, the photo will be deleted.

	 * @param tags Comma-separated list of tags associated with this event.
	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this checkin object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User to update the Event object on behalf of. The user must be the creator of the object.

The current user must be an application admin to update the Event object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsUpdate(String eventId, String name, java.util.Date startTime, Integer duration, String recurring, Integer recurringCount, String recurringUntil, String details, String placeId, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'eventId' is set
		if (eventId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'event_id' when calling eventsUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (eventId != null) formParams.put("event_id", eventId);
		if (name != null) formParams.put("name", name);
		if (startTime != null) formParams.put("start_time", startTime);
		if (duration != null) formParams.put("duration", duration);
		if (recurring != null) formParams.put("recurring", recurring);
		if (recurringCount != null) formParams.put("recurring_count", recurringCount);
		if (recurringUntil != null) formParams.put("recurring_until", recurringUntil);
		if (details != null) formParams.put("details", details);
		if (placeId != null) formParams.put("place_id", placeId);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Message objects.
	 * Retrieves the total number of Message objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show User Profile
	 * Shows public user information. For private information about the currently
logged in user, see {@link Users#show_me Show Logged In User Info}.

	 * 
	 * @param userId User ID of the user to show. Either `user_id` or `user_ids` must be specified.

	 * @param userIds Comma-separated list of user IDs to show. Either `user_id` or `user_ids` must be specified.

	 * @param responseJsonDepth Nested object depth level counts in response json.

In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param showUserLike If set to **true** the User object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersShow(String userId, String userIds, Number responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "user_ids", userIds));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Shows messages in the current user's inbox. Messages in the inbox have the
status of `unread`, `read`, or `replied`.

	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesShowInbox(Integer page, Integer perPage) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/show/inbox.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Query Arrow push notification logs.
	 * Performs a custom query of Arrow push notification logs with sorting and pagination. Returns
a list of {@link PushLogs} objects that matched the query parameters.

To get additional details about a specific PushLogs item, pass the value of PushLogs#_id to
a {@link Logs#querypushlogdetails} query.

	 * 
	 * @param where Constraint values for fields. `where` should be JSON encoded.

If `where` is not specified, query returns all objects.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject logsQuerypushlogs(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/logs/querypushlogs.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "where", where));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Places objects.
	 * Deletes Places objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Places objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.     

Any {@link #photo primary photos} associated with the matched objects are not deleted.

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Places objects to delete.
If not specified, all Places objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Status
	 * Performs a custom query of statuses with sorting and pagination. Currently you
can not query or sort data stored inside array or hash in custom fields.


In addition to custom fields, the following pre-defined fields can be used to
query and sort statuses:

*   `user_id` : `String`.  Status owner's user ID.
*   `event_id` : `String`.  ID for the {@link Events} associated with this status.
*   `place_id` : `String`.  ID for the {@link Places Place} associated with this status.
*   `created_at` : `Date`.  Timestamp when the status was created.
*   `updated_at` : `Date`.  Timestamp when the status was last updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Status object in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in the response JSON.  

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also 
some important data related to the returned objects, such as owners and
referenced objects.  

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Sends a message with an optional subject to one or more specified users. The `thread_id` of
the first outgoing message is its own id. Replies to the first or subsequent messages in
the thread will all use the id of the first message as their `thread_id`. The output of this
API method is the copy of the message saved to the sender's sent mail.

	 * 
	 * @param toIds Comma-separated list of one or more IDs of {@link Users} to send the message to.
	 * @param body The body of the message.
	 * @param subject Message subject.
	 * @param customFields User-defined data. See [Custom Objects and Custom Fields](/#!/guide/customfields).
	 * @param suId ID of the {@link Users} to send message on behalf of.

The current login user must be the application admin, in order to send a
message on behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesCreate(String toIds, String body, String subject, String customFields, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'toIds' is set
		if (toIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'to_ids' when calling messagesCreate");
		}
		// verify the required parameter 'body' is set
		if (body == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'body' when calling messagesCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (toIds != null) formParams.put("to_ids", toIds);
		if (body != null) formParams.put("body", body);
		if (subject != null) formParams.put("subject", subject);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Remove user(s) from an ACL
	 * Removes one or more user(s) from an ACL object with the given `id` or `name`.

You can remove users from the `readers` list, which grants read permission, the
`writers` list, which grants update/delete permission, or both.

	 * 
	 * @param name Name of the ACL object.

Either `name` or `id` must be specified.

	 * @param iD ID of the ACL oject.

Either `name` or `id` must be specified.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param readerIds Comma separated list of IDs to remove from the `readers` list.

	 * @param writerIds Comma separated list of IDs to remove from the `writers` list.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsRemove(String name, String iD, Boolean prettyJson, String readerIds, String writerIds) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'readerIds' is set
		if (readerIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'reader_ids' when calling aCLsRemove");
		}
		// verify the required parameter 'writerIds' is set
		if (writerIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'writer_ids' when calling aCLsRemove");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/remove.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (iD != null) formParams.put("id", iD);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (readerIds != null) formParams.put("reader_ids", readerIds);
		if (writerIds != null) formParams.put("writer_ids", writerIds);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * reset_badge
	 * Sets the internally stored value of the badge to zero of a specific device.

This method only updates the internally stored value of the badge.  To update the badge value
on the iOS icon or Android notification center, send a push notification with the `badge` field defined.

If you are an application admin, you may omit the device token.

	 * 
	 * @param deviceToken Device token. If you are an application admin, you may omit the device token.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsResetBadge(String deviceToken) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'deviceToken' is set
		if (deviceToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'device_token' when calling pushNotificationsResetBadge");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/reset_badge.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (deviceToken != null) formParams.put("device_token", deviceToken);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Count app&#39;s objects.
	 * 
	 * 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsCountObjects() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/app_object_counts.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Search Users
	 * Returns the list of users that have been added to the app, sorted by search
relevancy.

Optionally, `q` can be given to perform full text search on user's first name,
last name, email address, username and tags. For security reasons, when searching for {@link Users}
the {@link Users#email email} field is not returned in each Users object unless you have 
[admin access](#!/guide/admin_access).

For advanced custom search, see {@link Users#query query}.

	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param q Space-separated list of keywords, used to perform full text search on first name, last name, email address,
username and tags fields.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersSearch(Number page, Number perPage, String q, Number responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/search.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "q", q));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 *  Update an email template
	 * 
	 * 
	 * @param emailTemplateId Email template id.
	 * @param name Email template name.
	 * @param subject Email template subject.
	 * @param body Email template html body.
	 * @param plainBody Email template plain text body.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse emailTemplateEmailTemplatesUpdate(String emailTemplateId, String name, String subject, String body, String plainBody) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'emailTemplateId' is set
		if (emailTemplateId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'email_template_id' when calling emailTemplateEmailTemplatesUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/email_templates/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (emailTemplateId != null) formParams.put("email_template_id", emailTemplateId);
		if (name != null) formParams.put("name", name);
		if (subject != null) formParams.put("subject", subject);
		if (body != null) formParams.put("body", body);
		if (plainBody != null) formParams.put("plain_body", plainBody);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Create a Place
	 * Creates a new place object.

To create a place, you must specify at least one of the following:
address, city, state, postal_code, country, or geographical coordinates (longitude and latitude).

	 * 
	 * @param name Place name.
	 * @param address Address.
	 * @param city City.
	 * @param state State.
	 * @param postalCode Postal or ZIP code.
	 * @param country Country.
	 * @param latitude Latitude.
	 * @param longitude Longitude.
	 * @param website Website URL.
	 * @param twitter Twitter ID.
	 * @param phoneNumber Phone number.
	 * @param photo New photo to attach as the primary photo for this place.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for this place.

	 * @param tags Comma separated list of tags for this place.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this place object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this place object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create this place on behalf of.

The current login user must be an application admin to create a place on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesCreate(String name, String address, String city, String state, String postalCode, String country, Double latitude, Double longitude, String website, String twitter, String phoneNumber, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling placesCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (address != null) formParams.put("address", address);
		if (city != null) formParams.put("city", city);
		if (state != null) formParams.put("state", state);
		if (postalCode != null) formParams.put("postal_code", postalCode);
		if (country != null) formParams.put("country", country);
		if (latitude != null) formParams.put("latitude", latitude);
		if (longitude != null) formParams.put("longitude", longitude);
		if (website != null) formParams.put("website", website);
		if (twitter != null) formParams.put("twitter", twitter);
		if (phoneNumber != null) formParams.put("phone_number", phoneNumber);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create an ArrowDB app
	 * 
	 * 
	 * @param name App name
	 * @param description App's description
	 * @param ct App's description
	 * @param orgId Particular organization id.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsCreate(String ct, String name, String description, String orgId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "ct", ct));


		if (name != null) formParams.put("name", name);
		if (description != null) formParams.put("description", description);
		if (orgId != null) formParams.put("org_id", orgId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Custom Query Event Occurrences
	 * Perform custom query of event occurrences with sorting and paginating.

Currently, you can not query or sort data stored inside array or hash in custom
fields.

In addition to custom fields, you can query the following fields:

<table class="doc_content_table">
    <tr>
        <th>Name</th>
    <th>Type</th>
        <th>Summary</th>
    </tr>
  <tr>
    <td><code>name</code></td>
    <td>String</td>
    <td>Event's name</td>
  </tr>
  <tr>
    <td><code>user_id</code></td>
    <td>String</td>
    <td>Event owner's user id</td>
  </tr>
  <tr>
    <td><code>place_id</code></td>
    <td>String</td>
    <td>If an event belongs to a place, the associated place_id</td>
  </tr>
  <tr>
    <td><code>start_time</code></td>
    <td>Time</td>
    <td>Start time of an event occurrence</td>
  </tr>
  <tr>
    <td><code>end_time</code></td>
    <td>Time</td>
    <td>End time of an event occurrence</td>
  </tr>
  <tr>
    <td><code>lnglat</code></td>
    <td>Geo location array - [longitude, latitude]</td>
    <td>If an event belongs to a place, you can use <code>lnglat</code> to query events by place location</td>
  </tr>
</table>

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page Request page number, default is 1.

<p class="note">This parameter is only available to ArrowDB applications created before ArrowDB 1.1.5. 
Applications created with ArrowDB 1.1.5 and later must use <a href="#!/guide/search_query-section-query-pagination">ranged-based queries</a> queries
to paginate their queries.</p>

	 * @param perPage Number of results per page, default is 10.

<p class="note">This parameter is only available to ArrowDB applications created before ArrowDB 1.1.5. 
Applications created with ArrowDB 1.1.5 and later must use <a href="#!/guide/search_query-section-query-pagination">ranged-based queries</a> queries
to paginate their queries.</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned.

	 * @param skip Number of records to skip. Must be used together with `limit`.
The specified value must not be less than 0 or an HTTP 400 error will be returned.

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsQueryOccurrences(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/query/occurrences.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Statuses objects.
	 * Deletes Statuses objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Statuses objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process. The associated 
{@link #event Event}, {@link #photo Photo}, or {@link #place Place} of each matched object 
is not deleted.   

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Statuses objects to delete.
If not specified, all Statuses objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Checks a user&#39;s permission in an ACL.
	 * Checks the permissions a specified user is granted by a specified ACL.
In the response, "read_permission": "yes" means the user has read permission; if
this property is omitted or the value is not "yes", the user does not have read
permission.

Similarly, "write_permission": "yes" means the user has write permission. If the
property is omitted or the value is not "yes", the user does not have write
permission.

	 * 
	 * @param name Name of the ACL object.

Either `name` or `id` must be specified.

	 * @param iD ID of the ACL oject.

Either `name` or `id` must be specified.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param userId User ID of the user to check.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsCheck(String name, String iD, Boolean prettyJson, String userId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/check.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "name", name));
		queryParams.addAll(client.parameterToPairs("", "id", iD));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "user_id", userId));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * subscribe
	 * Subscribes a mobile device to a push notifications channel. Developers can
create different channels for different types of push notifications. For
instance, a channel for friend request, a channel for chat, etc. Push
notifications currently only work on iOS and Andriod.

	 * 
	 * @param channel Push notification channel to subscribe to. For multiple channels, comma separate the
list of channel names.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param deviceToken Apple or Android Device Token.
	 * @param type Selects the push type.

Set to `android` for Android devices using Google Cloud Messaging
or `ios` for iOS devices using Apple Push Notification Service.

	 * @param suId User ID to subscribe on behalf of.

Only application admins can subscribe to push notifications on behalf of other
users.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsSubscribe(String channel, String deviceToken, String type, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'channel' is set
		if (channel == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'channel' when calling pushNotificationsSubscribe");
		}
		// verify the required parameter 'deviceToken' is set
		if (deviceToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'device_token' when calling pushNotificationsSubscribe");
		}
		// verify the required parameter 'type' is set
		if (type == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'type' when calling pushNotificationsSubscribe");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/subscribe.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (channel != null) formParams.put("channel", channel);
		if (deviceToken != null) formParams.put("device_token", deviceToken);
		if (type != null) formParams.put("type", type);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Shows messages in the current user's sent messages.
	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesShowSent(Integer page, Integer perPage) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/show/sent.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Current User Profile
	 * Shows both public and private user information about the user who is
currently logged in.

	 * 
	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersShowMe(Number responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/show/me.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Files
	 * Perform custom query of files with sorting and paginating. Currently you can
not query or sort data stored inside custom fields that have Hash values.

In addition to custom fields, here is a list of pre-defined fields in the File
object that can be queried and sorted:

*   `user_id: String`.  User ID of the File's owner.

*   `created_at: Date`. Timestamp when the file was created.

*   `updated_at: Date`. Timestamp when the file was last updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param expires For private file permission, sets the expiration time in seconds for the temporary link
referencing the location to access the file. By default, the link expires in five minutes.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, String unsel, Integer responseJsonDepth, Integer expires, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "expires", expires));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query of Friends
	 * Performs custom query of Friends objects with sorting and paginating of the current
logged-in user or the specified user.  Only an application admin can perform a query against
a specified user using the `su_id` field.

If one-way friendship is enabled, the query returns the users being followed.  To return
the user's followers, set the `followers` field to true.

You can query or sort based on the data in any of the standard Friend fields.
You can also query and sort data based on the values of any custom fields,
if the values are simple JSON values.

Currently you **cannot** sort or query based on data stored inside array or hash
objects in custom fields.

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param suId ID of the user to search for friends. If friendship is set to one way, by default it
searches against users that the identified user is following. You can pass
`followers=true` to search the user's followers.
You must be an application admin to use this field.

	 * @param followers If set to true and one-way friendship is enabled, returns the user's followers instead
of the users being followed.

	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject friendsQuery(String suId, Boolean followers, Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/friends/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "su_id", suId));
		queryParams.addAll(client.parameterToPairs("", "followers", followers));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Replies to all recipients of the given message `id`. The status of the message
will be changed to `replied`.

	 * 
	 * @param messageId ID of the message to reply to.
	 * @param body Reply message body text.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesReply(String messageId, String body) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'messageId' is set
		if (messageId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'message_id' when calling messagesReply");
		}
		// verify the required parameter 'body' is set
		if (body == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'body' when calling messagesReply");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/reply.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (messageId != null) formParams.put("message_id", messageId);
		if (body != null) formParams.put("body", body);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Post
	 * Deletes the post with the given `id`. The original submitter can always delete
a post.

The {@link #photo primary photo} associated with the object is not deleted.        

An application admin can delete any Post object.

	 * 
	 * @param postId ID of the post to delete.
	 * @param suId User ID to delete the Post object on behalf of. The user must be the creator of the object.

The current login user must be an application admin to delete a Post object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsDelete(String postId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (postId != null) formParams.put("post_id", postId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Chat objects.
	 * Retrieves the total number of Chat objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject chatsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/chats/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create a Status
	 * Creates a status for the currenty logged in user. You can optionally associate a new status with 
either an existing {@link Places} object or an {@link Events} object, but not both.

Application admins can create a status on behalf of another user by including the
`su_id` field in the request.

	 * 
	 * @param message Status message.
	 * @param placeId ID of the {@link Places} object this status is associated with. You can associate the status 
either with a {@link Places} object or an {@link Events} object, but not both.

	 * @param eventId ID of the {@link Events} object this status is associated with. You can associate the status 
either with an {@link Events} object or a {@link Places} object, but not both.

	 * @param photo New photo to attach as the primary photo for this status.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for this status.

	 * @param tags Comma separated list of tags for this status.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this status.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this status.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the status on behalf of. You must be logged in as an application admin
to create a status on behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesCreate(String message, String placeId, String eventId, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'message' is set
		if (message == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'message' when calling statusesCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (message != null) formParams.put("message", message);
		if (placeId != null) formParams.put("place_id", placeId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Photos
	 * Perform custom query of photos with sorting and paginating. Currently you can
not query or sort data stored inside array or hash in custom fields.

In addition to custom fields, here is a list of pre-defined fields
that can be queried and sorted:

*   `user_id: String`. Photo owner's user ID.
*   `title:  String`.  Photo title.
*   `tags_array: String`. Photo tags.
*   `ratings_average:  Number`.  Photo's average rating (see {@link Reviews}).
*   `ratings_count: Number`. Photo's total number of ratings (see {@link Reviews}).
*   `reviews_count: Number`. Photo's total number of reviews (see {@link Reviews}).
*   `created_at: Date`. Timestamp when the photo was created.
*   `updated_at: Date`. Timestamp when the photo was updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Photo object in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Custom Object(s)
	 * Show a custom object's info.

	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @param iD The object ID of the custom object to show.

You must specify either `id` or `ids`.

	 * @param ids A comma-separated list of object IDs of the custom objects to show.

You must specify either `id` or `ids`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param showUserLike If set to **true** the CustomObject in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the
`current_user_liked` field is not included in the response.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsShow(String classname, String iD, String ids, Integer responseJsonDepth, Boolean prettyJson, Boolean showUserLike) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsShow");
		}
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling customObjectsShow");
		}
		// verify the required parameter 'ids' is set
		if (ids == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'ids' when calling customObjectsShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/show.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "id", iD));
		queryParams.addAll(client.parameterToPairs("", "ids", ids));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * unsubscribe_token
	 * Unsubscribes the specified device from a push notification channel.
If `channel` is not defined, unsubscribes the device from all channels.

	 * 
	 * @param channel Name of the push notification channel. For multiple channels, comma separate the list of
channel names.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param deviceToken Android or iOS device token.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsUnsubscribeToken(String channel, String deviceToken, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'deviceToken' is set
		if (deviceToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'device_token' when calling pushNotificationsUnsubscribeToken");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/unsubscribe_token.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (channel != null) formParams.put("channel", channel);
		if (deviceToken != null) formParams.put("device_token", deviceToken);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Search Places
	 * Returns the list of places that have been added to the app, sorted by search
relevancy.

Optionally, `latitude` and `longitude` can be given to return the list of
places starting from a particular location. To bound the results within a
certain radius (in km) from the starting coordinates, add the `distance`
parameter. `q` can be given to search by place name.

If you have provided a starting latitude and longitude for place search, each
result will return a distance to the starting point in km.

	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects, such as owners and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param latitude Latitude to center search on.
	 * @param longitude Longitude to center search on.
	 * @param distance Distance in km to search from the identified center point.
	 * @param q Space-separated list of keywords used to perform full text search on place name and tags.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesSearch(Integer page, Integer perPage, Integer responseJsonDepth, Double latitude, Double longitude, Double distance, String q, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/search.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "latitude", latitude));
		queryParams.addAll(client.parameterToPairs("", "longitude", longitude));
		queryParams.addAll(client.parameterToPairs("", "distance", distance));
		queryParams.addAll(client.parameterToPairs("", "q", q));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Set an apple certificate on an app.
	 * 
	 * 
	 * @param certificateDev Dev certificate file.
	 * @param devCertPassword Password for dev certificate file.
	 * @param certificateProd Prod certificate file.
	 * @param productionCertPassword Password for prod certificate file.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsSetAppleCertificates(File certificateDev, String devCertPassword, File certificateProd, String productionCertPassword) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/set_apple_certificates.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (certificateDev != null) formParams.put("certificate_dev", certificateDev);
		if (devCertPassword != null) formParams.put("dev_cert_password", devCertPassword);
		if (certificateProd != null) formParams.put("certificate_prod", certificateProd);
		if (productionCertPassword != null) formParams.put("production_cert_password", productionCertPassword);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Show Photo Info
	 * Returns the information for the identified photo.

	 * 
	 * @param photoId ID of the photo to show.
	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param showUserLike If set to **true** the Photo object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosShow(String photoId, Integer responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'photoId' is set
		if (photoId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'photo_id' when calling photosShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "photo_id", photoId));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query of Likes
	 * Performs custom query of likes with sorting and paginating.

You can either query the likes of an object using the object's ID,
such as the `post_id`, `photo_id`, etc. parameter, or the likes generated by a user,
by specifying the `user_id` parameter.

A non-administrator user can only retrieve results on the likes they generated.

Application administrators can retrieve results on the likes of all users and
query likes generated by other users by specifying the `user_id` parameter.

In addition to custom fields, the following pre-defined fields can be used to
query and sort likes:

*   `su_id` : `String`. User ID of the User that generated the likes.
    Only an application admininstrator can query likes of other users.
*   `likeable_type` : `String`. Object type of the like object, which is the name of the object,
    such as `Post`, `Photo`, etc.
*   `likeable_id` : `String`. Object ID of the like object.
*   `created_at` : `Date`. Timestamp when the like was created.
*   `updated_at` : `Date`. Timestamp when the like was last updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param postId Limit query to likes on the identified Post object.
	 * @param photoId Limit query to likes on the identified Photo object.
	 * @param eventId Limit query to likes on the identified Event object.
	 * @param placeId Limit query to likes on the identified Place object.
	 * @param checkinId Limit query to likes on the identified Checkin object.
	 * @param reviewId Limit query to likes on the identified Review object.
	 * @param customObjectId Limit query to likes on the identified Custom object.
	 * @param userObjectId Limit query to likes on the identified User object.
	 * @param suId Limit query to likes generated by the identified User.
Only an application administrator can query likes generated by other users.

	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects, such as owners and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject likesQuery(String postId, String photoId, String eventId, String placeId, String checkinId, String reviewId, String customObjectId, String userObjectId, String suId, Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/likes/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "post_id", postId));
		queryParams.addAll(client.parameterToPairs("", "photo_id", photoId));
		queryParams.addAll(client.parameterToPairs("", "event_id", eventId));
		queryParams.addAll(client.parameterToPairs("", "place_id", placeId));
		queryParams.addAll(client.parameterToPairs("", "checkin_id", checkinId));
		queryParams.addAll(client.parameterToPairs("", "review_id", reviewId));
		queryParams.addAll(client.parameterToPairs("", "custom_object_id", customObjectId));
		queryParams.addAll(client.parameterToPairs("", "user_object_id", userObjectId));
		queryParams.addAll(client.parameterToPairs("", "su_id", suId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Login with external account
	 * Users can login using an external account such as Facebook, Twitter,
Linkedin, etc without creating an account with Appcelerator Cloud Services
ahead of time. The external account login creates a Appcelerator Cloud
Services account if it hasn't been created, otherwise, it will login using the
user who has the matching external account info.

	 * 
	 * @param iD External account's user ID. Optional for Facebook; if ID is missing and `type`
is `facebook`, Appcelerator Cloud Services uses the Facebook token to obtain
the user ID.

	 * @param type Type of the external account, for example, "facebook", "linkedin", or
"twitter".

	 * @param token Token provided by the external account. Currently only Facebook tokens are
validated  by the Appcelerator Cloud Services server.

	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject socialIntegrationsExternalAccountLogin(String iD, String type, String token, String aclName, String aclId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling socialIntegrationsExternalAccountLogin");
		}
		// verify the required parameter 'type' is set
		if (type == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'type' when calling socialIntegrationsExternalAccountLogin");
		}
		// verify the required parameter 'token' is set
		if (token == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'token' when calling socialIntegrationsExternalAccountLogin");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/external_account_login.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (type != null) formParams.put("type", type);
		if (token != null) formParams.put("token", token);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show a review
	 * Shows the review with the given `id`.

	 * 
	 * @param reviewId Review object to show.
	 * @param showUserLike If set to **true** the Review object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsShow(String reviewId, Boolean showUserLike, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'reviewId' is set
		if (reviewId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'review_id' when calling reviewsShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "review_id", reviewId));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete an Event
	 * Delete the event with the given `id`. Only the original submitter can delete
the event.

The {@link #place Place} associated with the object is not deleted.

Application Admin can delete any Event object.

	 * 
	 * @param eventId ID of the event to delete.
	 * @param suId User to delete the Event object on behalf of. The user must be the creator of the object.

The current user must be an application admin to delete an Event object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsDelete(String eventId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'eventId' is set
		if (eventId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'event_id' when calling eventsDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (eventId != null) formParams.put("event_id", eventId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update a Post
	 * Updates the identified post. The original submitter can always update
a post.

An application admin can update any Post object.

	 * 
	 * @param postId ID of the post to update.
	 * @param content Text content of the post.
	 * @param title Title of the post.
	 * @param eventId ID of the {@link Events} this post belongs to.
	 * @param photo New photo to attach as the primary photo for this object.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for this object.

	 * @param tags Comma separated list of tags for this object.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

To remove an ACL, set `acl_name` or `acl_id` to an empty string.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

To remove an ACL, set `acl_name` or `acl_id` to an empty string.

	 * @param suId User ID to update the Post object on behalf of. The user must be the creator of the object.

The current login user must be an application admin to update a Post object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsUpdate(String postId, String content, String title, String eventId, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'postId' is set
		if (postId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'post_id' when calling postsUpdate");
		}
		// verify the required parameter 'content' is set
		if (content == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'content' when calling postsUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (postId != null) formParams.put("post_id", postId);
		if (content != null) formParams.put("content", content);
		if (title != null) formParams.put("title", title);
		if (eventId != null) formParams.put("event_id", eventId);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of objects of the specified class.
	 * Retrieves the total number of objects of the specified class.
	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsCount(String classname) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsCount");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/count.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show an ArrowDB app&#39;s details
	 * 
	 * 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsShow() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Show a status
	 * Returns the identified status message.

	 * 
	 * @param statusId ID of the status to show.
	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param showUserLike If set to **true** the Status object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesShow(String statusId, Integer responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'statusId' is set
		if (statusId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'status_id' when calling statusesShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "status_id", statusId));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Performs a custom query of Messages.
	 * Performs a custom query of Messages. Currently you can not query or sort data stored inside 
an array or hash in custom fields.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param where Constraint values for fields. `where` should be encoded JSON.

You can query any of the standard values for an ACL object, as well as any
custom fields that contain simple values, such as String, Number or Boolean
values.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesQuery(Integer page, Integer perPage, Integer limit, Integer skip, Boolean prettyJson, String where, String order, String sel, String unsel, Integer responseJsonDepth) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Photos in a Collection
	 * Show photos in a collection.

	 * 
	 * @param collectionId ID of the collection to retrieve photos from.
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as the object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsShowPhotos(String collectionId, Integer page, Integer perPage, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'collectionId' is set
		if (collectionId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'collection_id' when calling photoCollectionsShowPhotos");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/show/photos.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "collection_id", collectionId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Users objects.
	 * Deletes Users objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Users objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.      

The {@link #photo primary photos} associated with the matched objects are 
not deleted. 

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Users objects to delete.
If not specified, all Users objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Query details about a specific push notification log item.
	 * Performs a custom query for details about a specific Arrow push notification log item specified
in the query's `where` clause. Returns a {@link PushLogDetails} object for the specified log item.

	 * 
	 * @param where Where clause whose value is JSON object consisting of the field name "push_id"
and the ID of the push notification log item to query for, for example:

    where={"push_id":"<PUSHLOG_ID>"}

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject logsQuerypushlogdetails(String where) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'where' is set
		if (where == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'where' when calling logsQuerypushlogdetails");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/logs/querypushlogdetails.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "where", where));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Updates a Status
	 * Updates a status for the currenty logged in user. You can optionally associate the updated status 
with either an existing {@link Places} object or an {@link Events} object, but not both.

Application admins can update another user's status on their behalf by including the
`su_id` field in the request.

	 * 
	 * @param statusId ID of the status to update.
	 * @param message Status message.
	 * @param placeId ID of the {@link Places} object this status is associated with. You can associate the status 
either with a {@link Places} object or an {@link Events} object, but not both.

	 * @param eventId ID of the {@link Events} object this status is associated with. You can associate the status 
either with an {@link Events} object or a {@link Places} object, but not both.

	 * @param photo New photo to attach as the primary photo for this status.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for this status.

	 * @param tags Comma separated list of tags for this status.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this status.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this status.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to update the status on behalf of.

The current login user must be an application admin to update a status on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesUpdate(String statusId, String message, String placeId, String eventId, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'statusId' is set
		if (statusId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'status_id' when calling statusesUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (statusId != null) formParams.put("status_id", statusId);
		if (message != null) formParams.put("message", message);
		if (placeId != null) formParams.put("place_id", placeId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of ACL objects.
	 * Retrieves the total number of ACL objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of email templates.
	 * Retrieves the total number of email templates.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject emailsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/email_templates/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple PhotoCollections objects.
	 * Deletes PhotoCollections objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all PhotoCollections objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.        

The {@link #cover_photo cover photo} associated with any of the matched objects are not not deleted.

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for PhotoCollections objects to delete.
If not specified, all PhotoCollections objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Checkin objects.
	 * Deletes Checkin objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Checkin objects are deleted. Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process. The {@link #place Place}, 
{@link #event Event}, or {@link #photo Photo} associated with any of the matched objects is 
not deleted.

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Checkins objects to delete.
If not specified, all Checkins objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create Like
	 * Adds a "like" to an object. Currently, likes can only be associated with one of
the following object types, and a user can only like an object once:

*   {@link Posts}
*   {@link Photos}
*   {@link Users}
*   {@link Events}
*   {@link Checkins}
*   {@link Places}
*   {@link CustomObjects}
*   {@link Statuses}
*   {@link Reviews}

Once an object has one or more likes attached to it, it will return a
total like count with the object:

    "likes_count": 2

You should specify one, and only one, ArrowDB object ID parameter to identify the target object.

	 * 
	 * @param postId Post object to like.
	 * @param photoId Photo object to like.
	 * @param userId User object to like.
	 * @param eventId Event object to like.
	 * @param placeId Place object to like.
	 * @param checkinId Checkin object to like.
	 * @param statusId Status object to like.
	 * @param reviewId Review object to like.
	 * @param customObjectId Custom object to like.
	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject likesCreate(String postId, String photoId, String userId, String eventId, String placeId, String checkinId, String statusId, String reviewId, String customObjectId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/likes/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (postId != null) formParams.put("post_id", postId);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (userId != null) formParams.put("user_id", userId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (placeId != null) formParams.put("place_id", placeId);
		if (checkinId != null) formParams.put("checkin_id", checkinId);
		if (statusId != null) formParams.put("status_id", statusId);
		if (reviewId != null) formParams.put("review_id", reviewId);
		if (customObjectId != null) formParams.put("custom_object_id", customObjectId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Friend Requests
	 * View pending friend requests.

	 * 
	 * @param requestsTo If set to true, returns the users requesting the current user as a friend
rather than the pending friend requests that the user needs to approve.

	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being referred to, but also
some important data related to the returned objects such as object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject friendsRequests(Boolean requestsTo, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/friends/requests.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "requests_to", requestsTo));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 *  Show an email template
	 * 
	 * 
	 * @param emailTemplateId Email template id.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse emailTemplateEmailTemplatesShow(String emailTemplateId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'emailTemplateId' is set
		if (emailTemplateId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'email_template_id' when calling emailTemplateEmailTemplatesShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/email_templates/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "email_template_id", emailTemplateId));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Performs a custom query of KeyValues.
	 * Performs a custom query of KeyValues. Currently you can not query or sort data stored inside 
an array or hash in custom fields.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param where Constraint values for fields. `where` should be encoded JSON.

You can query any of the standard values for an ACL object, as well as any
custom fields that contain simple values, such as String, Number or Boolean
values.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesQuery(Integer page, Integer perPage, Integer limit, Integer skip, Boolean prettyJson, String where, String order, String sel, String unsel, Integer responseJsonDepth) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create Post
	 * Create a post, which can be a Facebook-style wall post or Digg-style
submission with content.

	 * 
	 * @param content Text content of the post.
	 * @param title Title of the post.
	 * @param eventId ID of the {@link Events} this post belongs to.
	 * @param photo New photo to attach as the primary photo for this object.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for this object.

	 * @param tags Comma separated list of tags for this object.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to create the object on behalf of.

The current login user must be an application admin to create an object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsCreate(String content, String title, String eventId, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'content' is set
		if (content == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'content' when calling postsCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (content != null) formParams.put("content", content);
		if (title != null) formParams.put("title", title);
		if (eventId != null) formParams.put("event_id", eventId);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Unlink an external account
	 * Disassociate an external account from a Appcelerator Cloud Services user
account.

	 * 
	 * @param iD External account's user ID.

	 * @param type Type of the external account, for example, "facebook", "linkedin", or
"twitter".

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject socialIntegrationsExternalAccountUnlink(String iD, String type, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling socialIntegrationsExternalAccountUnlink");
		}
		// verify the required parameter 'type' is set
		if (type == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'type' when calling socialIntegrationsExternalAccountUnlink");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/external_account_unlink.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (type != null) formParams.put("type", type);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show a Post
	 * Returns  the post with the given `id`.
	 * 
	 * @param postId Post ID to show.

Either `post_id` **or** `post_ids` must be specified.

	 * @param postIds Comma-separated list of post IDs.

Either `post_id` **or** `post_ids` must be specified.

	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the identified objects, but also
some important data related to the returned objects such as object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param showUserLike If set to **true** the Post object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsShow(String postId, String postIds, Integer responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "post_id", postId));
		queryParams.addAll(client.parameterToPairs("", "post_ids", postIds));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query of Users
	 * Custom query of Users objects with sorting and paginating. You can query on sort
based on the data in any of the standard User fields. You can also query and
sort data based on the values of any custom fields, if the values are simple JSON
values.

For security reasons, when querying for {@link Users} the {@link Users#email email} field is not returned
in each Users object unless you have [admin access](#!/guide/admin_access).

Currently you **cannot** sort or query based on data stored inside array or hash
objects in custom fields.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each User object in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Files objects.
	 * Deletes Files objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Files objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000. 

The matched objects are deleted asynchronously in a separate process.      

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Files objects to delete.
If not specified, all Files objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of GeoFence objects.
	 * Retrieves the total number of GeoFence objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject geoFencesCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/geo_fences/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Channels Show
	 * Returns the number of devices subscribed to the specified channel.

	 * 
	 * @param name Name of the push channel.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsChannelsShow(String name, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling pushNotificationsChannelsShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/channels/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "name", name));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Link an external Account
	 * Associates an external account with an existing Appcelerator Cloud Services
user account. Registered and logged in Appcelerator Cloud Services users can
link one or more external accounts to their existing account. Once linked, the
user can login using either Appcelerator Cloud Services account or any of the
linked external accounts.

	 * 
	 * @param iD External account's user ID. Optional for Facebook; if ID is missing and `type`
is `facebook`, Appcelerator Cloud Services uses the Facebook token to obtain
the user ID.

	 * @param type Type of the external account, for example, "facebook", "linkedin", or
"twitter".

	 * @param token Token provided by the external account. Currently only Facebook tokens are
validated  by the Appcelerator Cloud Services server.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject socialIntegrationsExternalAccountLink(String iD, String type, String token, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling socialIntegrationsExternalAccountLink");
		}
		// verify the required parameter 'type' is set
		if (type == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'type' when calling socialIntegrationsExternalAccountLink");
		}
		// verify the required parameter 'token' is set
		if (token == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'token' when calling socialIntegrationsExternalAccountLink");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/external_account_link.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (type != null) formParams.put("type", type);
		if (token != null) formParams.put("token", token);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Remove an apple certificate on an app
	 * 
	 * 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsRemoveAppleCertificates() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/remove_apple_certificates.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * 
	 * Delete all messages in a thread with the given `thread_id`. The thread must be
in the current user's inbox or sent mail. There is currently no trash folder
and deletion is permanent.

	 * 
	 * @param threadId Thread ID of the message thread to delete.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesDeleteThread(String threadId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'threadId' is set
		if (threadId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'thread_id' when calling messagesDeleteThread");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/delete/thread.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (threadId != null) formParams.put("thread_id", threadId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Append to a Key-Value
	 * Add the given `value` to end of the existing one. Not allowed on key-values
with binary data.

	 * 
	 * @param name Name (or key) for the key-value pair.
	 * @param value Value to append to the current value.
	 * @param accessPrivate Determines whether to update this key-value in the publically readable store
or in the user's private store.

Default is false (publically readable).

	 * @param suId Update the key-value pair on behalf of the identified user.

Login user must be an admin to update a key-value on behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesAppend(String name, String value, Boolean accessPrivate, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling keyValuesAppend");
		}
		// verify the required parameter 'value' is set
		if (value == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'value' when calling keyValuesAppend");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/append.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (value != null) formParams.put("value", value);
		if (accessPrivate != null) formParams.put("access_private", accessPrivate);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Send Emails
	 * Sends an email to a list of email addresses you specify. 

When sending an email, you specify the name of an email template created in Dashboard 
(see [Managing Email Templates](http://docs.appcelerator.com/platform/latest/#!/guide/Managing_Email_Templates)),
and one or more email recipients. You can optionally specify the email content type (
HTML, plain-text, or multipart), as well as values for any placeholder fields
defined by the template. The below examples demonstrate these concepts.

An email template's body can contain HTML-formatted or plain-text content 
, or both. When you send an email, you can specify whether the email should be sent 
as HTML, plain text, or multipart using the `content_type` parameter. 
A multipart email contains both the plain text and HTML versions; which 
version is displayed is determined by the recipient's email client.

If the `content_type` parameter is **not** provided in the request, the format
is automatically chosen based on the following rules:

* If the email template contains both HTML and plain-text bodies, it will be sent in a multipart format. 
* If the email template contains only an HTML body, it will be sent in an HTML format. 
* If the email template contains only a plain-text body. it will be sent in plain-text format.      

If the `content_type` parameter is provided in the request, then the following
must be true:

* If `content_type` is "html", then the email template must define an HTML body.
* If `content_type` is "plain", then the email template must define a plain text body.
* If `content_type` is "multipart", then the email template must define both HTML and plain text body.

	 * 
	 * @param template Name of the email template you have created.

	 * @param recipients Comma separated list of email addresses.
	 * @param contentType_ Specifies the email's content-type. The following values are valid:

* "plain" &mdash; If specified, the email template must define a plain text body.
* "html" &mdash; If specified, the email template must define an HTML body.
* "multipart" &mdash; If specified, the email template must define both a plain text
   and HTML body.
   
See [Managing Email Templates](http://docs.appcelerator.com/platform/latest/#!/guide/Managing_Email_Templates)
for details on creating email templates.

	 * @param from The sender's email address. 

**Notes**:
  
  * If you use Google as your SMTP server, the email will always be sent using the email account 
  you used to configure the SMTP service. 
  * Some SMTP service provider require the sender's email address to be present.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject emailsEmailFromTemplate(String template, String recipients, String contentType_, String from, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'template' is set
		if (template == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'template' when calling emailsEmailFromTemplate");
		}
		// verify the required parameter 'recipients' is set
		if (recipients == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'recipients' when calling emailsEmailFromTemplate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/custom_mailer/email_from_template.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (template != null) formParams.put("template", template);
		if (recipients != null) formParams.put("recipients", recipients);
		if (contentType_ != null) formParams.put("content_type", contentType_);
		if (from != null) formParams.put("from", from);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Chat Messages
	 * Performs a custom query of chat messages with sorting and pagination. Currently you can
not query or sort data stored inside array or hash in custom fields.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param participateIds Comma-separated list of user ID(s) of the users belonging to a chat group. You can use
this field to narrow down a query to a certain chat group. The current user can
only query chat messages in chat groups he or she is participating in.

For example, suppose that users A, B and C form one chat group, and users B and C form a second chat group without A.
User A does not have permission to query chats in the chat group that consists of
only users B and C.

You must specify either a `participate_ids` list or the `chat_group_id` of an existing
chat group to query.

	 * @param chatGroupId A chat group's id. Instead of using a `participate_ids` list, if you already
know the id of a chat group, you can use it to narrow down a query.

You must specify either a `participate_ids` list or the `chat_group_id` of an existing
chat group to query.

	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

You can query any of the standard values for a Chat object, as well as any
custom fields that contain simple values, such as String, Number or Boolean
values.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject chatsQuery(String participateIds, String chatGroupId, Integer page, Integer perPage, Boolean prettyJson, Integer limit, Integer skip, String where, String order, String sel, String unsel, Integer responseJsonDepth) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/chats/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "participate_ids", participateIds));
		queryParams.addAll(client.parameterToPairs("", "chat_group_id", chatGroupId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of File objects.
	 * Retrieves the total number of File objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Shows a message in the user's mailbox.
	 * 
	 * @param messageId ID of the message.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject messagesShow(String messageId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'messageId' is set
		if (messageId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'message_id' when calling messagesShow");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/messages/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "message_id", messageId));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Seach for Event Occurrences
	 * Full text search of event occurrences.

Optionally, `latitude` and `longitude` can be given to return the list of
event occurrences starting from a particular location (location is retrieved
from place if the event is associated with a place). To bound the results
within a certain radius (in km) from the starting coordinates, add the
`distance` parameter. `q` can be given to search by event name.

	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param placeId Restrict search results to events located in the identified {@link Places}.
	 * @param userId Restrict search results to events owned by the identified {@link Users}.
	 * @param latitude Latitude of the search starting point.
	 * @param longitude Longitude of the search starting point.
	 * @param distance Maximum distance in km from the starting point identified by
`longitude`, latitude`.

	 * @param startTime Only return events that start on or after `start_time`.
	 * @param endTime Only return events that end on or before `end_time`.
	 * @param q Space-separated list of keywords, used to perform full text search on event
name and tags.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsSearchOccurrences(Integer page, Integer perPage, String placeId, String userId, Double latitude, Double longitude, Double distance, java.util.Date startTime, java.util.Date endTime, String q, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/search/occurrences.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "place_id", placeId));
		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "latitude", latitude));
		queryParams.addAll(client.parameterToPairs("", "longitude", longitude));
		queryParams.addAll(client.parameterToPairs("", "distance", distance));
		queryParams.addAll(client.parameterToPairs("", "start_time", startTime));
		queryParams.addAll(client.parameterToPairs("", "end_time", endTime));
		queryParams.addAll(client.parameterToPairs("", "q", q));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Reviews&#x2F;Comments&#x2F;Ratings&#x2F;Likes
	 * Perform custom query of reviews with sorting and paginating. Currently you can
not query or sort data stored inside array or hash in custom fields.

The query must be limited to reviews of a given object (by specifying one of `post_id`,
`photo_id`, etc.) or limited to reviews generated by a given user (by specifying
`owner_id`.

In addition to custom fields, the following pre-defined fields can be used to
query and sort reviews:

*   `user_id` : `String`. Review owner's user ID.
*   `rating` : `Integer`. Rating assigned to this review.
*   `tags_array` : `String`. Tags associated with the review.
*   `created_at` : `Date`. Timestamp when the review was created.
*   `updated_at` : `Date`. Timestamp when the review was last updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).        

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param postId Limit query to reviews on the identified Post object.
	 * @param photoId Limit query to reviews on the identified Photo object.
	 * @param userId Limit query to reviews on the identified User object.
	 * @param eventId Limit query to reviews on the identified Event object.
	 * @param placeId Limit query to reviews on the identified Place object.
	 * @param checkinId Limit query to reviews on the identified Checkin object.
	 * @param reviewId Limit query to reviews on the identified Review object.
	 * @param customObjectId Limit query to reviews on the identified Custom object.
	 * @param statusId Limit query to reviews on the identified Status object.
	 * @param ownerId Limit query results to reviews submitted by the identified  user.
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Review object in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects, such as owners and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsQuery(String postId, String photoId, String userId, String eventId, String placeId, String checkinId, String reviewId, String customObjectId, String statusId, String ownerId, Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "post_id", postId));
		queryParams.addAll(client.parameterToPairs("", "photo_id", photoId));
		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "event_id", eventId));
		queryParams.addAll(client.parameterToPairs("", "place_id", placeId));
		queryParams.addAll(client.parameterToPairs("", "checkin_id", checkinId));
		queryParams.addAll(client.parameterToPairs("", "review_id", reviewId));
		queryParams.addAll(client.parameterToPairs("", "custom_object_id", customObjectId));
		queryParams.addAll(client.parameterToPairs("", "status_id", statusId));
		queryParams.addAll(client.parameterToPairs("", "owner_id", ownerId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * 
	 * Subscribes a mobile device to a push notifications channel.

Developers can create different channels for different types of push notifications, such as
a friend request, chat, etc.

	 * 
	 * @param deviceToken Android or iOS device token.

For Android, the length is dynamic and is less than 4096 characters.

For iOS, the length is 64 characters.

	 * @param channel Name of the channel. For multiple channels, comma separate the list of channel names.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param type Selects the push type.

Set to `android` for Android devices using Google Cloud Messaging
or `ios` for iOS devices using Apple Push Notification Service.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsSubscribeToken(String deviceToken, String channel, String type, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'deviceToken' is set
		if (deviceToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'device_token' when calling pushNotificationsSubscribeToken");
		}
		// verify the required parameter 'channel' is set
		if (channel == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'channel' when calling pushNotificationsSubscribeToken");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/subscribe_token.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (deviceToken != null) formParams.put("device_token", deviceToken);
		if (channel != null) formParams.put("channel", channel);
		if (type != null) formParams.put("type", type);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Photo Collection
	 * Delete an empty collection. An error will be returned if a collection contains
any photos or subcollections.

An application admin can delete any photo collection. The {@link #cover_photo} associated 
with the collection is not deleted.

	 * 
	 * @param collectionId ID of the collection to delete.
	 * @param suId User ID to delete the collection on behalf of. The user must be the creator of the collection.

The current login user must be an application admin to delete a collection on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsDelete(String collectionId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'collectionId' is set
		if (collectionId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'collection_id' when calling photoCollectionsDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (collectionId != null) formParams.put("collection_id", collectionId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Event
	 * Show event(s) with the given IDs.

	 * 
	 * @param eventId ID of the event to delete.

Either `event_id` or `event_ids` must be specified.

	 * @param eventIds Comma-separated list of event IDs to show.
	 * @param responseJsonDepth Nested object depth level counts in response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the identified objects, but also some important data related
to the returning objects such as object's owner or referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param showUserLike If set to **true** the Event object in the response will include `"current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsShow(String eventId, String eventIds, Integer responseJsonDepth, Boolean showUserLike, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/show.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "event_id", eventId));
		queryParams.addAll(client.parameterToPairs("", "event_ids", eventIds));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Drops a CustomObjects collection.
	 * Drops a CustomObjects collection of a specified type. The collection is dropped
asynchronously in a separate process.

You must be an application admin to run this command.

	 * 
	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsAdminDropCollection(String classname) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsAdminDropCollection");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/admin_drop_collection.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 *  Create an email template
	 * 
	 * 
	 * @param name Email template name.
	 * @param subject Email template subject.
	 * @param body Email template html body.
	 * @param plainBody Email template plain text body. At least one of body and plain_body is required for one template. And body is to store html format email content, and plain_body is to store plain text email content. 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse emailTemplateEmailTemplatesCreate(String name, String subject, String body, String plainBody) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling emailTemplateEmailTemplatesCreate");
		}
		// verify the required parameter 'subject' is set
		if (subject == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'subject' when calling emailTemplateEmailTemplatesCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/email_templates/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (subject != null) formParams.put("subject", subject);
		if (body != null) formParams.put("body", body);
		if (plainBody != null) formParams.put("plain_body", plainBody);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * Login as admin using dashboard authentication or dashboard secret token(x-auth-token). x-auth-token has high priority than connect.sid if they are existing at the same time.
	 * 
	 * 
	 * @param connectSid App name
	 * @param groupId 
	 * @param ct If the app is enterprise.
	 * @param xAuthToken 
	 * @param email 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse adminLogin360(String connectSid, String groupId, String ct, String xAuthToken, String email) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'connectSid' is set
		if (connectSid == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'connect.sid' when calling adminLogin360");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/admins/login360.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "connect.sid", connectSid));
		queryParams.addAll(client.parameterToPairs("", "group_id", groupId));
		queryParams.addAll(client.parameterToPairs("", "ct", ct));
		queryParams.addAll(client.parameterToPairs("", "x-auth-token", xAuthToken));
		queryParams.addAll(client.parameterToPairs("", "email", email));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * 
	 * Any of the same parameters as {@link Users#create create} can be
used to update the current user. If `password` is updated then
`password_confirmation` must be sent as well.

	 * 
	 * @param email Email address.
	 * @param username User name.
	 * @param password Password.
	 * @param passwordConfirmation Password.
	 * @param firstName First name.
	 * @param lastName First name.
	 * @param photo New photo to assign as the user's primary photo.

When you use `photo` parameter to attach a new photo, you can use it with
[custom resize and sync options](/docs/photosizes)

To remove primary photo, simply set "photo=" or "photo_id=". If the original
photo was created by using `photo` parameter, the photo will be deleted.

	 * @param photoId ID of an existing photo to use as the user's primary photo.

To remove primary photo, simply set "photo=" or "photo_id=". If the original
photo was created by using `photo` parameter, the photo will be deleted.

	 * @param tags Comma separated tags, overwrites the existing tags. For example, "hiking,swimming".

	 * @param customFields User-defined data. See [Custom Data Fields](/docs/customfields).

	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to update this user on behalf of.

The current login user must be an application admin to update a user on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersUpdate(String email, String username, String password, String passwordConfirmation, String firstName, String lastName, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (email != null) formParams.put("email", email);
		if (username != null) formParams.put("username", username);
		if (password != null) formParams.put("password", password);
		if (passwordConfirmation != null) formParams.put("password_confirmation", passwordConfirmation);
		if (firstName != null) formParams.put("first_name", firstName);
		if (lastName != null) formParams.put("last_name", lastName);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Logs user into the system
	 * 
	 * 
	 * @param login The user name for login
	 * @param password The password for login in clear text
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersLoginUser(String login, String password) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'login' is set
		if (login == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'login' when calling usersLoginUser");
		}
		// verify the required parameter 'password' is set
		if (password == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'password' when calling usersLoginUser");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/login.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (login != null) formParams.put("login", login);
		if (password != null) formParams.put("password", password);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update a Photo Collection
	 * Updates a photo collection.

An existing collection's cover photo can be added or updated by specifying a
new `cover_photo_id`. The cover photo can be removed by sending an empty
string as the value for `cover_photo_id`.
Application Admin can update any Photo Collection.

	 * 
	 * @param collectionId ID of the collection to update.
	 * @param name New name of the collection. The name must be unique across other top-level
collections. If this is a sub-collection, the name must be unique across other
sub-collections of the same parent.

	 * @param coverPhotoId ID of the photo to use as a cover photo. The photo does not need to be
in the collection.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this collection.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this collection.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User ID to update the collection on behalf of. The user must be the creator of the collection.

The current login user must be an application admin to update a collection on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsUpdate(String collectionId, String name, String coverPhotoId, String customFields, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (collectionId != null) formParams.put("collection_id", collectionId);
		if (name != null) formParams.put("name", name);
		if (coverPhotoId != null) formParams.put("cover_photo_id", coverPhotoId);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * unsubscribe
	 * Unsubscribes one of the current user's devices from a push notification channel. If channel name is not
provided, unsubscribe the device from all channels.

When a user logs out from a device, you can cancel all subscriptions for the
device by passing the device's token to the {@link Users#logout} method.

	 * 
	 * @param channel Name of the push notification channel. For multiple channels, comma separate the list of
channel names.

The name of the push channel cannot start with a hash symbol ('#') or contains a comma (',').

	 * @param deviceToken Apple or Android Device Token.
	 * @param userId User ID to unsubscribe from push notifications.

Only application admins can unsubscribe another user from push notifications.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsUnsubscribe(String channel, String deviceToken, String userId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'deviceToken' is set
		if (deviceToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'device_token' when calling pushNotificationsUnsubscribe");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/unsubscribe.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (channel != null) formParams.put("channel", channel);
		if (deviceToken != null) formParams.put("device_token", deviceToken);
		if (userId != null) formParams.put("user_id", userId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of KeyValue objects.
	 * Retrieves the total number of KeyValue objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject keyValuesCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/keyvalues/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create an access control list
	 * Creates an ACL object, which can be used to control access to ArrowDB objects.

	 * 
	 * @param name Name of the ACL object.

	 * @param readerIds Comma separated list of IDs identifying users who can read objects
controlled by this ACL.

	 * @param writerIds Comma separated list of IDs identifying users who can update an object.
controlled by this ACL.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param publicRead Determines whether objects controlled by this ArrowDB are publically readable.

Default is false.

	 * @param publicWrite Determines whether objects controlled by this ArrowDB are publically writable.

Default is false.

	 * @param suId Specifies the owner of the new URL.

Only allowed if the current login user is an application admin. Otherwise, the
new ACL is always owned by the current login user.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsCreate(String name, String readerIds, String writerIds, Boolean prettyJson, String publicRead, String publicWrite, String suId) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling aCLsCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (readerIds != null) formParams.put("reader_ids", readerIds);
		if (writerIds != null) formParams.put("writer_ids", writerIds);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (publicRead != null) formParams.put("public_read", publicRead);
		if (publicWrite != null) formParams.put("public_write", publicWrite);
		if (suId != null) formParams.put("su_id", suId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Add user(s) to an ACL.
	 * Adds one or more user(s) to an existing ACL object, identified by its `id` or `name`.

	 * 
	 * @param name Name of the ACL object.

Either `name` or `id` must be specified.

	 * @param iD ID of the ACL oject.

Either `name` or `id` must be specified.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param readerIds Comma separated list of IDs identifying users who can read objects
controlled by this ACL.

	 * @param writerIds Comma separated list of IDs identifying users who can update an object.
controlled by this ACL.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsAdd(String name, String iD, Boolean prettyJson, String readerIds, String writerIds) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'readerIds' is set
		if (readerIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'reader_ids' when calling aCLsAdd");
		}
		// verify the required parameter 'writerIds' is set
		if (writerIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'writer_ids' when calling aCLsAdd");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/add.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (iD != null) formParams.put("id", iD);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);
		if (readerIds != null) formParams.put("reader_ids", readerIds);
		if (writerIds != null) formParams.put("writer_ids", writerIds);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Log out a user.
	 * 
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersLogoutUser() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/logout.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Post objects.
	 * Retrieves the total number of Post objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject postsCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/posts/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Checkins
	 * Performs a custom query of checkins with sorting and pagination. Currently you
can not query or sort data stored inside array or hash in custom fields.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page Request page number, default is 1.

<p class="note">This parameter is only available to ArrowDB applications created before ArrowDB 1.1.5. 
Applications created with ArrowDB 1.1.5 and later must use <a href="#!/guide/search_query-section-query-pagination">ranged-based queries</a> queries
to paginate their queries.</p>

	 * @param perPage Number of results per page, default is 10.

<p class="note">This parameter is only available to ArrowDB applications created before ArrowDB 1.1.5. 
Applications created with ArrowDB 1.1.5 and later must use <a href="#!/guide/search_query-section-query-pagination">ranged-based queries</a> queries
to paginate their queries.</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Checkin object in the response includes "current_user_liked: true"`
if the current user has liked the object. If the user has not liked the object, the
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject checkinsQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/checkins/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Re-send user email verification.
	 * If you enabled new user account email verification in your App settings, all
new users will receive an email containing instructions to activate their
account. You can use this API to re-send user verification email.

	 * 
	 * @param email Email must match user's registered email.
	 * @param confirmationSubject The default subject of the email verification is "Email Verification
Instructions for <your app name>". If you wish to have your custom email
subject, you can provide it by setting the `confirmation_subject` parameter.

	 * @param confirmationTemplate If you wish to use your custom email body. You can create a email template and
pass the template name. Your email template must contain the following URL to
allow users to be redirected to Appcelerator Cloud Services email verification page:

    https://cloud.appcelerator.com/users/confirmation?key=<key>&confirmation_token=<confirmation_token>

If you have your own website that talks to Appcelerator Cloud Services backend
and wish to use custom URL, you must provide a URL with the following format:

    https://[your_url.com]/[your_method]?key=<key>&confirmation_token=<confirmation_token>

When a user visits the above URL, you make a call to Appcelerator Cloud
Services to confirm the user internally from your web server:

    GET https://api.cloud.appcelerator.com/v1/users/confirm_user.json?confirmation_token=<confirmation_token>&key=<Your App Key>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject usersResendConfirmation(String email, String confirmationSubject, String confirmationTemplate, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'email' is set
		if (email == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'email' when calling usersResendConfirmation");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/users/resend_confirmation.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "email", email));
		queryParams.addAll(client.parameterToPairs("", "confirmation_subject", confirmationSubject));
		queryParams.addAll(client.parameterToPairs("", "confirmation_template", confirmationTemplate));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update the Subscription
	 * Updates the device's push channel subscription.

	 * 
	 * @param deviceToken Apple or Android Device Token.
	 * @param suId User ID to update the subscription on behalf of. You must be logged in as an application administrator
to update another user's notification subscription.

	 * @param loc The device's current location specified as an array with longitude as the first element, and latitude
as the second element (`[longitude,latitude]`).

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsSubscriptionUpdate(String deviceToken, String suId, String loc, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'deviceToken' is set
		if (deviceToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'device_token' when calling pushNotificationsSubscriptionUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/subscription/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (deviceToken != null) formParams.put("device_token", deviceToken);
		if (suId != null) formParams.put("su_id", suId);
		if (loc != null) formParams.put("loc", loc);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Set an android settings on an app.
	 * 
	 * 
	 * @param androidAppPackage 
	 * @param androidGcmApikey 
	 * @param androidGcmSenderId 
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsSetAndroidCertificate(String androidAppPackage, String androidGcmApikey, String androidGcmSenderId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/set_android_certificate.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (androidAppPackage != null) formParams.put("android_app_package", androidAppPackage);
		if (androidGcmApikey != null) formParams.put("android_gcm_apikey", androidGcmApikey);
		if (androidGcmSenderId != null) formParams.put("android_gcm_sender_id", androidGcmSenderId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * 
	 * Create an event. Times given with time zones other than UTC (for example PST
during daylight savings is -0700) will be converted to UTC. An ical string
will be returned to represent the occurrences of the event.

For the event that is set as a recurring event, once created, there will be
several "event occurrences" created associating with the event object on
server side, one "event occurrence" represents a single occurrence of the
recurring event. An "event occurrence" contains start and end time of the
event's occurrence which are calculated according to the "recurring" settings
of the event object.

Instead of computing actual individual occurrences of a recurring event on the
client side, you can use event occurrences query api to get a list of
occurrences associated of a repeating event.

To get all occurrences for a recurring event object, you can call {@link Events#show_occurrences}
event occurrence](/docs/api/v1/events/show_occurrences) and pass in the
event's `id`.

	 * 
	 * @param name Event name.
	 * @param startTime Event start time.
	 * @param details Description of the event.
	 * @param duration Event duration, in seconds.
	 * @param recurring Recurrance schedule. Can take the following values: "daily", "weekly", "monthly", or "yearly".

Must be used together with `recurring_count` or `recurring_until` to limit the
number of occurances. The total number of occurrences of an event in either
case is limited to 1000.

	 * @param recurringCount Number of occurrences for the event.
	 * @param recurringUntil Date of last recurrance.
	 * @param placeId ID for the {@link Places} where the event takes place.
	 * @param photo New photo to attach as the primary photo for the event.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for the event.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this event.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this event.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param tags Comma-separated list of tags associated with this event.
	 * @param suId User ID to create the event on behalf of.

The current login user must be an application admin to create an event on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsCreate(String name, java.util.Date startTime, String details, Integer duration, String recurring, Integer recurringCount, String recurringUntil, String placeId, File photo, String photoId, String customFields, String aclName, String aclId, String tags, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'name' is set
		if (name == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'name' when calling eventsCreate");
		}
		// verify the required parameter 'startTime' is set
		if (startTime == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'start_time' when calling eventsCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (startTime != null) formParams.put("start_time", startTime);
		if (details != null) formParams.put("details", details);
		if (duration != null) formParams.put("duration", duration);
		if (recurring != null) formParams.put("recurring", recurring);
		if (recurringCount != null) formParams.put("recurring_count", recurringCount);
		if (recurringUntil != null) formParams.put("recurring_until", recurringUntil);
		if (placeId != null) formParams.put("place_id", placeId);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (tags != null) formParams.put("tags", tags);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update a Place
	 * Any of the parameters used to {@link Places#create Create a Place} can
be used to update it as well. Only the user that created the place can update
it.

An application admin can update any place object.

	 * 
	 * @param placeId ID of the place to delete.
	 * @param name Place name.
	 * @param address Address.
	 * @param city City.
	 * @param state State.
	 * @param postalCode Postal or ZIP code.
	 * @param country Country.
	 * @param latitude Latitude.
	 * @param longitude Longitude.
	 * @param website Website URL.
	 * @param twitter Twitter ID.
	 * @param phoneNumber Phone number.
	 * @param photo New photo to attach as the primary photo for this place.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for this place.

	 * @param tags Comma separated list of tags for this place.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this place object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this place object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param userId User ID to assign as the owner of the place object. The current user must have write
access to the object in order to update the owner.

	 * @param suId User ID to update the Place object on behalf of. The user must be the creator of the object.

The current login user must be an application admin to update a Place object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesUpdate(String placeId, String name, String address, String city, String state, String postalCode, String country, Double latitude, Double longitude, String website, String twitter, String phoneNumber, File photo, String photoId, String tags, String customFields, String aclName, String aclId, String userId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'placeId' is set
		if (placeId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'place_id' when calling placesUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (placeId != null) formParams.put("place_id", placeId);
		if (name != null) formParams.put("name", name);
		if (address != null) formParams.put("address", address);
		if (city != null) formParams.put("city", city);
		if (state != null) formParams.put("state", state);
		if (postalCode != null) formParams.put("postal_code", postalCode);
		if (country != null) formParams.put("country", country);
		if (latitude != null) formParams.put("latitude", latitude);
		if (longitude != null) formParams.put("longitude", longitude);
		if (website != null) formParams.put("website", website);
		if (twitter != null) formParams.put("twitter", twitter);
		if (phoneNumber != null) formParams.put("phone_number", phoneNumber);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (userId != null) formParams.put("user_id", userId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Performs a custom query of ACLs.
	 * Performs a custom query of ACLs. Regular application users can only query ACLs that they have created. 
Application admins can query ACLs for an arbitrary user by specifying the `user_id` method parameter.
(In applications created with ArrowDB 1.1.7 and earlier, any user can query another user's 
ACLs, regardless of whether they are an admin or not.)

<p class="note">The <code>name</code> field is not queryable.</p>

* Applications created with ArrowDB 1.1.5 and later can paginate query results using `skip` 
and `limit` parameters. For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).
* Currently you can not query or sort data stored inside an array or hash in custom fields.

For general information on queries, see [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param count Used for paginating queries. If set to `true`, the response's `meta` object contains a 
`count` field that indicates the number of objects that matched the query constraints.

	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param userId ID of the user whose ACLs should be returned. You must be an application admin to use this 
parameter.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject aCLsQuery(Boolean count, Integer page, Integer perPage, Boolean prettyJson, Integer limit, Integer skip, String order, String sel, String unsel, Integer responseJsonDepth, String userId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/acls/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "count", count));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "user_id", userId));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Create a Chat Message
	 * Sends a chat message to another user or a group of users.

Sending a message creates a new chat group if there is no existing chat group
containing the current user and the designated recipients.

To generate a push notification, include the `channel` and
`payload` parameters.

	 * 
	 * @param toIds Comma-separated list of user ID(s) to receive the message. The current user ID and `to_ids`
together determine which chat group a message belongs to. The chat group is
created if necessary.

You must specify either a `to_ids` list or the `chat_group_id` for an existing
chat group.

	 * @param chatGroupId Identifies an existing chat group by ID. If you already know the id
of a {@link Chats#property-chatgroup chat group}, you can use it to specify
which chat group this message should go to.

You must specify either a `to_ids` list or the `chat_group_id` for an existing
chat group.

	 * @param message Message to send.
	 * @param photo New photo to attach to the chat message.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach to the chat message.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param channel Channel for a push notification.

To send a push notification to the recipients after a new chat
message is created, you can pass in the `channel` and `payload` parameters.
For more information, see {@link PushNotifications#notify}.

	 * @param payload Message payload for push notification.


The message defined in `payload` will be delivered to all the recipients as long
as they have {@link PushNotifications#subscribe subscribed} to the specified channel.

For example, if all of your app's users are subscribed to channel "Chat", then
you can pass channel -- "Chat", and payload:

    {
        "from": "sender user_id",
        "message": "Hello everyone!",
        "sound": "default",
         "alert" : "From Joe: Hello everyone!"
    }

	 * @param suId Send on behalf of the identified user.

Current user must be an application admin to send a message on behalf of
another user.

	 * @param responseJsonDepth To receive a list of participant IDs, set `response_json_depth` to **2**.
If you have already cached all the user objects participating
in the chat group and wish to receive a smaller JSON response, you can set
`response_json_depth` to **1** to remove participant user's info from chat group in
the JSON response.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject chatsCreate(String toIds, String chatGroupId, String message, File photo, String photoId, String customFields, String channel, String payload, String suId, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'message' is set
		if (message == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'message' when calling chatsCreate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/chats/create.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (toIds != null) formParams.put("to_ids", toIds);
		if (chatGroupId != null) formParams.put("chat_group_id", chatGroupId);
		if (message != null) formParams.put("message", message);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (channel != null) formParams.put("channel", channel);
		if (payload != null) formParams.put("payload", payload);
		if (suId != null) formParams.put("su_id", suId);
		if (responseJsonDepth != null) formParams.put("response_json_depth", responseJsonDepth);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Show Subcollections
	 * Show subcollections of a collection.

	 * 
	 * @param collectionId ID of the collection to retrieve photos from.
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects such as the object's owner or
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photoCollectionsShowSubcollections(String collectionId, Integer page, Integer perPage, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'collectionId' is set
		if (collectionId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'collection_id' when calling photoCollectionsShowSubcollections");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/collections/show/subcollections.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "collection_id", collectionId));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Events
	 * Perform custom query of events with sorting and paginating. Currently you can
not query or sort data stored inside array or hash in custom fields.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

In addition to the custom fields, you can query the following event fields:

<table>
    <tr>
        <th>Name</th>
    <th>Type</th>
        <th>Summary</th>
    </tr>
  <tr>
    <td><code>name</code></td>
    <td>String</td>
    <td>Event's name</td>
  </tr>
  <tr>
    <td><code>user_id</code></td>
    <td>String</td>
    <td>Event owner's user ID</td>
  </tr>
  <tr>
    <td><code>place_id</code></td>
    <td>String</td>
    <td>If an event belongs to a place, the associated place_id</td>
  </tr>
  <tr>
    <td><code>tags_array</code></td>
    <td>Array</td>
    <td>Array of tags assigned to the Event.</td>
  </tr>
  <tr>
    <td><code>start_time</code></td>
    <td>Time</td>
    <td>Start time of an event</td>
  </tr>
  <tr>
    <td><code>num_occurences</code></td>
    <td>Integer</td>
    <td>Number of time the event repeats</td>
  </tr>
  <tr>
    <td><code>lnglat</code></td>
    <td>Geo location array - [longitude, latitude]</td>
    <td>If an event belongs to a place, you can use <code>lnglat</code> to query events by place location</td>
  </tr>
  <tr>
    <td><code>created_at</code></td>
    <td>Date</td>
    <td>Timestamp when the event was created</td>
  </tr>
  <tr>
    <td><code>updated_at</code></td>
    <td>Date</td>
    <td>Timestamp when the event was last updated</td>
  </tr>
</table>

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

<p class="note">This parameter is only available to ArrowDB applications created before ArrowDB 1.1.5.
Applications created with ArrowDB 1.1.5 and later must use <a href="#!/guide/search_query-section-query-pagination">ranged-based queries</a> queries
to paginate their queries.</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Event in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the current user has not liked the object, the
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Set production apps as the package info in the global app db.
	 * Set production apps as the package info in the global app db.
	 * 
	 * @param orgId Set production apps as the package info in the global app db.
	 * @param packageInfo A hash string which must include 'apiRateMinute' and 'allowProduction', the 'type' of 'packageInfo' can be 'free', 'starter', 'trial', 'professional', or 'enterprise'.
	 * @param xAuthToken The dashboard access token.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject orgOrgUpdate(String orgId, String xAuthToken, String packageInfo) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'orgId' is set
		if (orgId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'org_id' when calling orgOrgUpdate");
		}
		// verify the required parameter 'xAuthToken' is set
		if (xAuthToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'x-auth-token' when calling orgOrgUpdate");
		}
		// verify the required parameter 'packageInfo' is set
		if (packageInfo == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'packageInfo' when calling orgOrgUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/org/{org_id}".replaceAll("\\{format\\}","json")
			.replaceAll("\\{org_id\\}", client.escapeString(orgId.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();


		if (xAuthToken != null) headerParams.put("x-auth-token", client.parameterToString(xAuthToken));

		if (packageInfo != null) formParams.put("packageInfo", packageInfo);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Used to disable the production apps according to setting the &#39;status&#39; to 1 in the global_apps collection.
	 * Used to disable the production apps according to setting the 'status' to 1 in the global_apps collection.
	 * 
	 * @param orgId Used to disable the production apps according to setting the 'status' to 1 in the global_apps collection.
	 * @param xAuthToken The dashboard access token.
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject orgOrgDelete(String orgId, String xAuthToken) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'orgId' is set
		if (orgId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'org_id' when calling orgOrgDelete");
		}
		// verify the required parameter 'xAuthToken' is set
		if (xAuthToken == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'x-auth-token' when calling orgOrgDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/org/{org_id}".replaceAll("\\{format\\}","json")
			.replaceAll("\\{org_id\\}", client.escapeString(orgId.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();


		if (xAuthToken != null) headerParams.put("x-auth-token", client.parameterToString(xAuthToken));


		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Custom Query Places
	 * Performs custom query of places with sorting and paginating. Currently you can
not query or sort data stored inside array or hash in custom fields.

The following fields can be used for querying and sorting places:

*   `address` : String.  Place address.
*   `city` : String.  Place city.
*   `state` : String. Place state.
*   `country` : String.  Country.
*   `user_id` : String. ID of the user who created this place.
*   `google_cid` : Google Customer ID (CID) associated with this place.
*   `tags_array` : String. Search tags.
*   `lnglat` : `[longitude, latitude]`. The Place's default coordinates. You can also store
     custom coordinates in a custom field and query for those coordinates separately 
     (see [Geographic Coordinates in Custom Fields](#!/guide/customfields-section-geographic-coordinates-in-custom-fields)).
*   `ratings_average:  Number`.  Place's average rating (see {@link Reviews}).
*   `ratings_count: Number`. Place's total number of ratings (see {@link Reviews}).
*   `reviews_count: Number`. Place's total number of reviews (see {@link Reviews}).
*   `created_at: Date`. Timestamp when the photo was created.
*   `updated_at: Date`. Timestamp when the photo was updated.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

For details about using the query parameters,
see the [Search and Query guide](#!/guide/search_query).

	 * 
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param where Constraint values for fields. `where` should be encoded JSON.

If `where` is not specified, `query` returns all objects.

	 * @param order Sort results by one or more fields.

	 * @param sel Selects the object fields to display. Do not use this parameter with `unsel`.

	 * @param showUserLike If set to **true**, each Place object in the response includes `"current_user_liked: true"`
 if the current user has liked the object. If the user has not liked the object, the 
`current_user_liked` field is not included in the response.

	 * @param unsel Selects the object fields NOT to display. Do not use this parameter with `sel`.

	 * @param responseJsonDepth Nested object depth level counts in the response JSON.

In order to reduce server API calls from an application, the response JSON may
include not just the objects that are being queried/searched, but also
some important data related to the returned objects, such as owners and
referenced objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject placesQuery(Integer page, Integer perPage, Integer limit, Integer skip, String where, String order, String sel, Boolean showUserLike, String unsel, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/places/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "where", where));
		queryParams.addAll(client.parameterToPairs("", "order", order));
		queryParams.addAll(client.parameterToPairs("", "sel", sel));
		queryParams.addAll(client.parameterToPairs("", "show_user_like", showUserLike));
		queryParams.addAll(client.parameterToPairs("", "unsel", unsel));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update a Review&#x2F;Comment&#x2F;Rating&#x2F;Like
	 * Updates the review with the given `id`.

Ordinary users can update reviews they own or have update access to.

An application admin can update a Review on behalf of another user by 
specifying that user's ID in the `user_id` method parameter.

	 * 
	 * @param postId ID of the {@link Posts} object to review.

	 * @param photoId ID of the {@link Photos} object to review.

	 * @param userObjectId ID of the {@link Users} object to review.

	 * @param eventId ID of the {@link Events} object to review.

	 * @param placeId ID of the {@link Places} object to review.

	 * @param checkinId ID of the {@link Checkins} object to review.

	 * @param reviewObjectId ID of the {@link Reviews} object to review.

	 * @param customObjectId ID of the {@link CustomObjects} object to review.

	 * @param statusId ID of the {@link Statuses} object to review.

	 * @param reviewId ID of the Review object to update.
	 * @param content Review or comment text.
	 * @param rating Rating to be associated with review. You can use "1" to represent one {@link Likes Like}.
	 * @param suId ID of the {@link Users} object to update the review on behalf of. The currently 
logged-in user must be an application admin to create a review on
behalf of another user.

	 * @param allowDuplicate By default, the same user can only submit one review/comment per object.
Set this flag to `true` to allow the user to add multiple  reviews or comments to
the same object.

	 * @param tags Comma separated list of tags for this review.

	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject reviewsUpdate(String postId, String photoId, String userObjectId, String eventId, String placeId, String checkinId, String reviewObjectId, String customObjectId, String statusId, String reviewId, String content, String rating, String suId, Boolean allowDuplicate, String tags, String customFields, String aclName, String aclId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'reviewId' is set
		if (reviewId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'review_id' when calling reviewsUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/reviews/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (postId != null) formParams.put("post_id", postId);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (userObjectId != null) formParams.put("user_object_id", userObjectId);
		if (eventId != null) formParams.put("event_id", eventId);
		if (placeId != null) formParams.put("place_id", placeId);
		if (checkinId != null) formParams.put("checkin_id", checkinId);
		if (reviewObjectId != null) formParams.put("review_object_id", reviewObjectId);
		if (customObjectId != null) formParams.put("custom_object_id", customObjectId);
		if (statusId != null) formParams.put("status_id", statusId);
		if (reviewId != null) formParams.put("review_id", reviewId);
		if (content != null) formParams.put("content", content);
		if (rating != null) formParams.put("rating", rating);
		if (suId != null) formParams.put("su_id", suId);
		if (allowDuplicate != null) formParams.put("allow_duplicate", allowDuplicate);
		if (tags != null) formParams.put("tags", tags);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Retrieves the total number of Status objects.
	 * Retrieves the total number of Status objects.
	 * 
	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject statusesCount() throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/statuses/count.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();




		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update Custom Object
	 * Any of the same parameters as [Create Custom
Object](/docs/api/v1/custom_objects/create) can be used to update a custom
object. Only the owner of the object or user who is entitled write
permission(ACL) to the object can update the object.

Application Admin can update any Custom Object.

	 * 
	 * @param iD The object ID of the custom object to update.

	 * @param classname Type of custom object. Specified as part of the URL path, not in the
parameters.

	 * @param fields JSON encoding of object fields to update.

If any of the fields do not exist in the current object, they will be added.
To delete an existing field, use {"field_name" : null}. For example, the car object created in
{@link CustomObjects#create CustomObject.create} is:

    { "make": "nissan",
      "color": "blue",
      "year": 2005,
      "purchased_at": "2011-11-02 17:07:37 -0700",
      "used": false,
      "coordinates": [-122.1, 37.1]
    }

To change color, remove the `purchased_at` field and add a new field `mileage`,
you could pass the following JSON object to fields:

    { "color": "purple",
      "purchased_at": null,
      "mileage": 10000
    }

	 * @param tags Comma-separated list of tags to associate with this object, for example, "hiking,swiming."
Replaces any existing tags.

If the `tags` parameter is omitted and a `tags` key is included in the
`fields` dictionary, `fields.tags` will be used instead.

	 * @param photo New photo to attach as the primary photo for the object.

When you use the `photo` parameter to attach a new photo, you can use the
[custom resize and sync options](#!/guide/photosizes).

	 * @param photoId ID of an existing photo to attach as the primary photo for the object.

	 * @param aclName Name of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param suId User to update the Custom object on behalf of. The user must be the creator of the object.

The current user must be an application admin to update a Custom object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject customObjectsUpdate(String classname, String iD, String fields, String tags, File photo, String photoId, String aclName, String aclId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'classname' is set
		if (classname == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'classname' when calling customObjectsUpdate");
		}
		// verify the required parameter 'iD' is set
		if (iD == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'id' when calling customObjectsUpdate");
		}
		// verify the required parameter 'fields' is set
		if (fields == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'fields' when calling customObjectsUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/objects/{classname}/update.json".replaceAll("\\{format\\}","json")
			.replaceAll("\\{classname\\}", client.escapeString(classname.toString()));
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (iD != null) formParams.put("id", iD);
		if (fields != null) formParams.put("fields", fields);
		if (tags != null) formParams.put("tags", tags);
		if (photo != null) formParams.put("photo", photo);
		if (photoId != null) formParams.put("photo_id", photoId);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update an ArrowDB app
	 * 
	 * 
	 * @param name App name.
	 * @param description App description.
	 * @param friendsTwoWay Friend Request Type.
	 * @param allowUserCreation Allow user creation in the app.
	 * @param newUserVerification New User Email Verification
	 * @param secureIdentity false : api, true : auth secure identity server.
	 * @param orgId Particular organization id.
	 * @return SuccessResponse
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public SuccessResponse appsAppsUpdate(String name, String description, Boolean friendsTwoWay, Boolean allowUserCreation, Boolean newUserVerification, Boolean secureIdentity, String orgId) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/apps/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (name != null) formParams.put("name", name);
		if (description != null) formParams.put("description", description);
		if (friendsTwoWay != null) formParams.put("friends_two_way", friendsTwoWay);
		if (allowUserCreation != null) formParams.put("allow_user_creation", allowUserCreation);
		if (newUserVerification != null) formParams.put("new_user_verification", newUserVerification);
		if (secureIdentity != null) formParams.put("secure_identity", secureIdentity);
		if (orgId != null) formParams.put("org_id", orgId);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (SuccessResponse) client.deserialize(result, new TypeToken<SuccessResponse>() {}.getType());
	}

	/**
	 * notify
	 * Sends push notifications to one or more users who are subscribed to a channel.

Specify either `friends`, `to_ids` or `where`.
One of these parameters must be used. These parameters cannot be used simultaneously.

Application admins can set the `to_ids` parameter to `everyone` to send to all devices
subscribed to the identified channel.

The REST version of `notify` includes the push notification ID in its response.
See the REST example below.

	 * 
	 * @param channel Name of the channel. For multiple channels, either comma-separate the list of channels
or use an array of strings.

The name of the push channel cannot start with a hash symbol ('#') or contain a comma (',').

	 * @param friends If this parameter is specified (regardless of the parameter's value),
push notifications are sent to any of the user's {@link Friends} who are
subscribed to the identified channel.

	 * @param toIds Comma-separated list of user IDs to send the notification to users who are subscribed
to the specified channel. Up to 1000 users can be specified.

You **cannot** use this parameter when using a location query with the `where` parameter.

Application admins can set this parameter to `everyone` to send to all devices
subscribed to the channel.

If you are using the web interface, you do not need to specify this parameter.

	 * @param payload Payload to send with the push notification.

For a string, it will be sent as an alert (notification message).

	 * @param options Additional push options.

* *expire_after_seconds* (Number): Expiration time in seconds of when to stop sending the push notification.
  For example, if the push notification expiration time is for a day and the user's device
  is off for over a day, the user does not receive the push notification since it has expired.

For example, to specify a one day expiration period, use `options={'expire_after_seconds':86400}`.

	 * @param where A JSON-encoded object that defines either the user or location query used to select the device
that will receive the notification. Up to 1000 users can be returned by the query.

If you are using a location query, you **cannot** use the `to_ids` parameter.

To specify a user query, set the `user` field to a custom query, for example, the
following query searches for all users with the first name of Joe:

    where={"user": {"first_name":"Joe">

To specify a location query, set the `loc` field to a
[MongoDB Geospatial Query](http://docs.mongodb.org/manual/reference/operator/query-geospatial/).
The following query searches for all users within 2 km of Oakland, CA, USA:

    where={"loc": { "$nearSphere" : { "$geometry" : { "type" : "Point" , "coordinates" : [-122.2708,37.8044] } , "$maxDistance" : 2000 >}

For details about using the `where` parameter, see the [Search and Query guide](#!/guide/search_query).

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushNotificationsNotify(String channel, String friends, String toIds, String payload, String options, String where, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'channel' is set
		if (channel == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'channel' when calling pushNotificationsNotify");
		}
		// verify the required parameter 'payload' is set
		if (payload == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'payload' when calling pushNotificationsNotify");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_notification/notify.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (channel != null) formParams.put("channel", channel);
		if (friends != null) formParams.put("friends", friends);
		if (toIds != null) formParams.put("to_ids", toIds);
		if (payload != null) formParams.put("payload", payload);
		if (options != null) formParams.put("options", options);
		if (where != null) formParams.put("where", where);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Search for Events
	 * Full text search of events.

Optionally, `latitude` and `longitude` can be given to return the list of
events starting from a particular location (location is retrieved from place
if the event is associated with a place). To bound the results within a
certain radius (in km) from the starting coordinates, add the `distance`
parameter. `q` can be given to search by event name.

	 * 
	 * @param page Request page number, default is 1.
	 * @param perPage Number of results per page, default is 10.
	 * @param placeId Restrict search results to events located in the identified {@link Places}.
	 * @param userId Restrict search results to events owned by the identified {@link Users}.
	 * @param latitude Latitude of the search starting point.
	 * @param longitude Longitude of the search starting point.
	 * @param distance Maximum distance in km from the starting point identified by
`longitude`, latitude`.

	 * @param startTime Only return events that start on or after `start_time`.
	 * @param q Space-separated list of keywords, used to perform full text search on event
name and tags.

	 * @param responseJsonDepth Nested object depth level counts in response json.
In order to reduce server API calls from an application, the response json may
include not just the objects that are being queried/searched, but also with
some important data related to the returning objects such as object's owner or
referencing objects.

Default is 1, valid range is 1 to 8.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsSearch(Integer page, Integer perPage, String placeId, String userId, Double latitude, Double longitude, Double distance, java.util.Date startTime, String q, Integer responseJsonDepth, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/search.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "place_id", placeId));
		queryParams.addAll(client.parameterToPairs("", "user_id", userId));
		queryParams.addAll(client.parameterToPairs("", "latitude", latitude));
		queryParams.addAll(client.parameterToPairs("", "longitude", longitude));
		queryParams.addAll(client.parameterToPairs("", "distance", distance));
		queryParams.addAll(client.parameterToPairs("", "start_time", startTime));
		queryParams.addAll(client.parameterToPairs("", "q", q));
		queryParams.addAll(client.parameterToPairs("", "response_json_depth", responseJsonDepth));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Deletes multiple Events objects.
	 * Deletes Events objects that match the query constraints provided in the `where` parameter.
If no `where` parameter is provided, all Events objects are deleted. 
Note that an HTTP 200 code (success)
is returned if the call completed successfully but the query matched no objects.

For performance reasons, the number of objects that can be deleted in a single batch delete 
operation is limited to 100,000.

The matched objects are deleted asynchronously in a separate process.

Any {@link #place Place} associated with the matched objects are not deleted.

You must be an application admin to run this command.

	 * 
	 * @param where Encoded JSON object that specifies constraint values for Events objects to delete.
If not specified, all Events objects are deleted.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject eventsBatchDelete(String where) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/events/batch_delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (where != null) formParams.put("where", where);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Update a File
	 * Updates an existing file object with a binary attachment, or contents of a URL. When replacing the existing file with a
new one, the object's `processing` flag is set to `false`, and its `url` property will not be valid
until the new file has been processed and uploaded to the Appcelerator Cloud
Services storage cloud.

Application administrators can update any File object.

	 * 
	 * @param fileId ID of the file to update.
	 * @param name File name.
	 * @param file The attached binary file to upload to ArrowDB. You can specify either `file` or `url`, but not both.
	 * @param customFields User defined fields. See [Custom Data Fields](#!/guide/customfields).
	 * @param aclName Name of an {@link ACLs} to associate with this file object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param aclId ID of an {@link ACLs} to associate with this file object.

An ACL can be specified using `acl_name` or `acl_id`. The two parameters are
mutually exclusive.

	 * @param s3Acl Permission level of the file.  Set to either:

  * `private`: Only a logged-in user can access the file.
  * `public_read`: Anyone can access the file (default).

This can only be set if you also update the `file` or `url`.

For private permission, when you retrieve the URL for the file using either the show or
query method, the link is temporary and will expire. The default is five minutes.
When exporting data, the exported URL will be a root URL and not a direct URL to the file.

To restrict file access to specific users, use an ACL.

	 * @param suId User to update the File object on behalf of. The user must be the creator of the object.

The current user must be an application admin to update a File object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject filesUpdate(String fileId, String name, File file, String customFields, String aclName, String aclId, String s3Acl, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'fileId' is set
		if (fileId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'file_id' when calling filesUpdate");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/files/update.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (fileId != null) formParams.put("file_id", fileId);
		if (name != null) formParams.put("name", name);
		if (file != null) formParams.put("file", file);
		if (customFields != null) formParams.put("custom_fields", customFields);
		if (aclName != null) formParams.put("acl_name", aclName);
		if (aclId != null) formParams.put("acl_id", aclId);
		if (s3Acl != null) formParams.put("s3_acl", s3Acl);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded", "multipart/form-data"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Approve Friend Requests
	 * Approve an existing friend request. Each user will be added to the other's
friend list.

	 * 
	 * @param userIds Comma-separated list consisting of IDs of one or more users to approve as
friends to the current user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject friendsApprove(String userIds, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'userIds' is set
		if (userIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'user_ids' when calling friendsApprove");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/friends/approve.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (userIds != null) formParams.put("user_ids", userIds);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "put", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Add Friends
	 * Add friends to the current user. By default the friend request is two-way
(like Facebook), so after a friend request is made and approved both users
will show up in each others' friend lists. This default can be changed to one-
way following (like Twitter) in the App Settings for each of your apps.

Two-way or one-way friend requests must be approved by the recipient unless
`approval_required=false` is also sent with the request. This allows the user
to add any user as a friend without requiring approval.

	 * 
	 * @param userIds Comma-separated list consisting of IDs of one or more users to add as
friends to the current user. A user cannot add himself or herself as a friend.

	 * @param approvalRequired Indicates whether the friend request requires
approval by the other users.

Default: `true`

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject friendsAdd(String userIds, Boolean approvalRequired, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'userIds' is set
		if (userIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'user_ids' when calling friendsAdd");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/friends/add.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (userIds != null) formParams.put("user_ids", userIds);
		if (approvalRequired != null) formParams.put("approval_required", approvalRequired);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			"application/x-www-form-urlencoded"
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "post", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Delete a Photo
	 * Deletes a photo to which you have update access.

An application admin can delete any photo object.

	 * 
	 * @param photoId ID of the photo to delete.
	 * @param suId User ID to delete the Photo object on behalf of. The user must be the creator of the object.

The current login user must be an application admin to delete a Photo object on
behalf of another user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject photosDelete(String photoId, String suId, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'photoId' is set
		if (photoId == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'photo_id' when calling photosDelete");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/photos/delete.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (photoId != null) formParams.put("photo_id", photoId);
		if (suId != null) formParams.put("su_id", suId);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * query
	 * Queries the list of scheduled push notifications.

The current logged-in user must be an application admin to use this API.

In ArrowDB 1.1.5 and later, you can paginate query results using `skip` and `limit` parameters, or by including
a `where` clause to limit the results to objects whose IDs fall within a specified range.
For details, see [Query Pagination](#!/guide/search_query-section-query-pagination).

	 * 
	 * @param name Name given to the scheduled push notification.
	 * @param page <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param perPage <p class="note">
Starting in ArrowDB 1.1.5, page and per_page are no longer supported in query operations. 
Applications should instead use <strong>skip</strong> and <strong>limit</strong> 
query parameters.
</p>

	 * @param limit The number of records to fetch. The value must be greater than 0, and no greater than 
1000, or an HTTP 400 (Bad Request) error will be returned. Default value of `limit` is 10.

	 * @param skip The number of records to skip. The value must be greater than or equal to 0, and no greater 
than 4999, or an HTTP 400 error will be returned. To skip 5000 records or more 
you need to perform a range-based query. See 
<a href="#!/guide/search_query-section-query-pagination">Query Pagination</a> for more information.</p>

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject pushSchedulesQuery(String name, Integer page, Integer perPage, Integer limit, Integer skip, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/push_schedule/query.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();

		queryParams.addAll(client.parameterToPairs("", "name", name));
		queryParams.addAll(client.parameterToPairs("", "page", page));
		queryParams.addAll(client.parameterToPairs("", "per_page", perPage));
		queryParams.addAll(client.parameterToPairs("", "limit", limit));
		queryParams.addAll(client.parameterToPairs("", "skip", skip));
		queryParams.addAll(client.parameterToPairs("", "pretty_json", prettyJson));



		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "get", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

	/**
	 * Remove Friends
	 * Removes one or more friends from the user's friends list.

	 * 
	 * @param userIds Comma-separated list consisting of IDs of one or more users to remove from the current user.

	 * @param prettyJson Determines if the JSON response is formatted for readability (`true`), or displayed on a
single line (`false`). Default is `false`.

	 * @return JSONObject
	 * @throws SdkException if fails to make API call
	 */
	 @SuppressWarnings("unchecked")
	public JSONObject friendsRemove(String userIds, Boolean prettyJson) throws SdkException {
		Object bodyParameter = null;
		// verify the required parameter 'userIds' is set
		if (userIds == null) {
			throw new SdkException(SdkException.MISSING_PARAMETER, "Missing the required parameter 'user_ids' when calling friendsRemove");
		}
		if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
  		 // On UI thread.
		    throw new SdkException(SdkException.ERROR_RUNNING_ON_UI_THREAD, "API Call is running on UI thread. Please call it inside an Async task or a thread");
		}
		// create path and map variables
		String localVarPath = "/friends/remove.json".replaceAll("\\{format\\}","json");
		// query params
		List<Pair> queryParams = new ArrayList<>();
		Map<String, String> headerParams = new HashMap<>();
		Map<String, Object> formParams = new HashMap<>();



		if (userIds != null) formParams.put("user_ids", userIds);
		if (prettyJson != null) formParams.put("pretty_json", prettyJson);

		final String[] accepts = {
			"application/json"
		};

		final String accept = client.selectHeaderAccept(accepts);

		final String[] contentTypes = {
			
		};
		final String contentType = client.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] { "OAuthImplicit", "OAuthAccessCode" };

		Result result = client.invokeAPI(localVarPath, "delete", queryParams, bodyParameter, headerParams, formParams, accept, contentType, authNames);
		return (JSONObject) client.deserialize(result, new TypeToken<JSONObject>() {}.getType());
	}

}
