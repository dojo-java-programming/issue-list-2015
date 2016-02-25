<html>
	<head>
        <meta  charset="utf-8" />
        <link  rel="stylesheet" href="css/extract-and-modify.css" />
        <title>Issue List</title>
	</head>

<body>
<h1>${name}</h1>

<table class="table-fill">
<thead>
  <tr>
  	<th>Issue Id</th>
  	<th>Title</th>
  	<th>Status</th>
  	<th>Priority</th>
  	<th>Type</th>
  	<th>Creation Date</th>
  	<th>Description</th>
  </tr>
</thead>

<tbody  class="table-hover">
<#list issues as issue>
  <tr>
  	<td>${issue.issueId.id}</td>
  	<td>${issue.title}</td>
  	<td>${issue.status}</td>
  	<td>${issue.priority}</td>
  	<td>${issue.type}</td>
  	<td>${issue.creationDate?string('yyyy.MM.dd')}</td>
  	<td>${issue.description}</td>
  </tr>
</#list>
</tbody>

</table>


</body>
</html>