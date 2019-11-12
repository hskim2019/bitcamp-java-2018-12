var tbody = document.querySelector('tbody');

document.querySelector('#search-btn').onclick = () => {

  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function () {
    if (xhr.readyState !=4 || xhr.status != 200)
      return;
    
    var obj = JSON.parse(xhr.responseText);
   
   tbody.innerHTML = '';
   for(data of obj.list) {
     var tr = '<tr>'
     + '<td scope="row">' + data.no + '</td>'
     + '<td><a class="bit-view-link" href="#" data-no="' + data.no + '">' + data.name + '</a></td>'
     + '<td>' + data.email + '</td>'
     + '<td>' + data.tel + '</td>'
     + '<td>' + data.registeredDate + '</td>'
     + '</tr>';
      tbody.innerHTML = tbody.innerHTML + tr;
   }
   
    document.body.dispatchEvent(new Event('loaded-list'));
    
  };
  var keyword = document.querySelector('#searchWord').value;
  console.log(keyword);
  xhr.open('GET', '../../app/json/member/search?keyword=' + keyword, true);
  xhr.send(keyword);
 
};



