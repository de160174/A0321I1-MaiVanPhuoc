let product = ["Sony Xperia", "Samsung Galaxy", "Nokia 6", "Apple XS", "Xiaomi mi 5s plus", "Apple iPhone 8 plus", "Fujitsu F-04E", "Oppo A71"];
display(product);
function addNew() {
  let nameSP = document.getElementById("name").value;
  if (nameSP != "") {
    product.push(nameSP);
  } else {
    alert("nhập tên sản phẩm");
  }
  document.getElementById("name").value = "";
  display(product);
}

function display(list) {
  let tableString = '<table>\n' +
    '  <tr>\n' +
    '    <th>STT</th>\n' +
    '    <th>Tên sản phẩm</th>\n' +
    '    <th>Sửa</th>\n' +
    '    <th>Xóa</th>\n' +
    '    <tr>';
  for (let i = 0; i < list.length; i++) {
    tableString += '<tr>\n' +
      '      <td>' + (i + 1) + '</td>\n' +
      '      <td>' + list[i] + '</td>\n' +
      '      <td><button value="Sửa" onclick="editSP(' + i + ');">Sửa</button></td>\n' +
      '      <td><button value="Xóa" onclick="deleteSP(' + i + ');">Xóa</button></td>\n' +
      '    </tr>'
  }
  tableString += '<table>';
  document.getElementById("hienthi").innerHTML = tableString;
  document.getElementById("sl").innerHTML = list.length+ " product";

}

function editSP(index) {
  let editName = prompt("nhập vào tên mới sản phẩm");
  if (editName != "" && editName != null) {
    product[index] = editName;
  }
  display(product);
}

function deleteSP(index) {
  let xacnhan = confirm("bạn có muốn xóa sản phẩm " + product[index]);
  if (xacnhan) {
    product.splice(index, 1);
  } else {
    alert("bạn không xóa");
  }
  display(product);
}

