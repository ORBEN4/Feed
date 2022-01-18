import 'package:flutter/foundation.dart';
// import 'package:http/http.dart' as http;
import 'package:http/http.dart';

Future<void> main() async {
  var url = Uri.parse('https://example.com/whatsit/create');
  Response response = await post(
      url, body: {'name': 'doodle', 'color': 'blue'});

  if (kDebugMode) {
    print('Response status: ${response.statusCode}');
    print('Response body: ${response.body}');
    print(await read(Uri.parse('https://example.com/foobar.txt')));
  }
}