# WalmartAndroid
Walmart Product App on Android

DESIGN DOCUMENTATION:

Architectural Pattern: MVP 
Procedural outline generally goes as follows:
- user prompt to load whichever info he/she chooses
- REST query to Walmart API
- receive & parse results
- organize data using given classes (create the displaying data MODEL)
- display data visually (User's VIEW)

This general procedure more closely fits an MVP pattern, thus defining the development approach of this app.





QUESTIONS:
The Walmart API is generally pretty slow, what are some optimizations that could be implemented to improve the user experience?

	The data centers hosting and processing the Walmart API queries may be out of our control. However, we can make implementations that bypass or compensate for any shortcomings - this is in our control.

	There is one concept that can be implemented for this optimization: frequent user queries can have results saved for later use, while being updated whenever necessary. Therefore, frequent user queries would skip REST API calls and instead load more accessible data - helping optimize the user experience.


If pagination on the products page was not implemented, how would you implement?

	The biggest improvement necessary in the Walmart API pagination implementation may be a redesign of its page segmentation. 

	In its current state, paginated product collections appear to be segmented (depending on item sizes between 1 and 1000) as if they were a singly linkedlist. In other words, the first page has an ID to its next page, which has an ID on its next page, and so on (but currently no ID for its previous page)

	I would implement page segmentation as an indexed array, if possible. The overall product collections are still segmented (i.e. pages), but should also be indexed in order from first to last. 

	There is notable potential for its benefits. For example, API queries can instantly get the 7th page of a product collection (given some category) without any extra implementation. 


Any improvements you would make to your application?

	Long-term, I would consider expanding the platform onto iOS and as a web app. 

	A potential obstacle here is the distinct diverse requirements of both platforms differing from Android. To address this issue, I would explore tech stacks that cater to all end-user platforms (for example, Unity-C# is a gaming resource for both mobile platforms as well as web apps).

