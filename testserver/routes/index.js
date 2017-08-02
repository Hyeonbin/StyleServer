var express = require('express');
var router = express.Router();
var mysql = require('mysql');
var pool = mysql.createPool({
  connectionLimit: 5,
  host: 'localhost',
  user: 'root',
  database: 'test',
  password: 'xpfksWkd'
});

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/data', function(req, res, next) {
  pool.getConnection(function(err, connection) {
    var sqlForSelect = "SELECT * FROM responsedata";

    connection.query(sqlForSelect, function (err, sel1) {
      if(err)
        console.error("err : " + err);

      var sqlForSelect1 = "SELECT * FROM simpleobject ORDER BY id DESC";

      connection.query(sqlForSelect1, function (err, sel2) {
        if(err)
          console.error("err : " + err);

        var simple = [{sel1, sel2: sel2}];
        //var simpleobject = JSON.stringify(simple)
        res.json(simple);
        connection.release();
      });
    });
  });
});

module.exports = router;
