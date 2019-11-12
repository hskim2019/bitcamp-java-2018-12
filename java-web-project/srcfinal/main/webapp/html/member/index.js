var pageNo = 1,
    pageSize = 3,
    tbody = document.querySelector('tbody'),
    prevPageLi = document.querySelector('#prevPage'),
    nextPageLi = document.querySelector('#nextPage'),
    currSpan = document.querySelector('#currPage > span');

function loadList(pn) {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function () {
    if (xhr.readyState !=4 || xhr.status != 200)
      return;
    
   var obj = JSON.parse(xhr.responseText);
   
   pageNo = obj.pageNo;
   
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
   
   currSpan.innerHTML = String(pageNo)
   
   if(pageNo == 1) {
     prevPageLi.className = prevPageLi.className + ' disabled';
   } else {
     prevPageLi.className = prevPageLi.className.replace(' disabled', '');
   }
   
   if(pageNo == obj.totalPage) {
     nextPageLi.className = nextPageLi.className + ' disabled';
   } else {
     nextPageLi.className = nextPageLi.className.replace(' disabled', '');
   }
   
    document.body.dispatchEvent(new Event('loaded-list'));
    document.body.dispatchEvent(new Event('search-list'));
  };
  xhr.open('GET', '../../app/json/member/list?pageNo=' + pn + '&pageSize=' + pageSize, true)
  xhr.send();
 
}

document.querySelector('#prevPage > a').onclick = (e) => {
  e.preventDefault();
  loadList(pageNo - 1);
}

document.querySelector('#nextPage > a').onclick = (e) => {
  e.preventDefault();
  loadList(pageNo + 1);
}

loadList(1);

document.body.addEventListener('loaded-list', () => {
  
  var alist = document.querySelectorAll('.bit-view-link');
  for (a of alist) {
    a.onclick = (e) => {
      e.preventDefault();
      window.location.href = 'view.html?no=' + e.target.getAttribute('data-no');
    }
   }
});

document.body.addEventListener('search-list', () => {
  
  var searchlist = document.querySelectorAll('#searchWord');
  
  searchlist.onclick = (e) => {
      e.preventDefault();
      window.location.href = 'search.html?keyword=' + e.target.getAttribute('search');
    }
});

/*document.querySelector('#search-btn').onclick = () => {

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
 
};*/



