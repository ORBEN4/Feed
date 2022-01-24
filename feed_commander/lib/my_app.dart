import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return  MaterialApp(
      theme: ThemeData.light(),
      darkTheme: ThemeData.dark(),
      home: Scaffold(
        body: const ExpansionTileExample(data),
        appBar: AppBar(
          title: const Text("my users"),
        ),
      ),
      // ExpansionTileExample(),
      title: "my users",
      debugShowCheckedModeBanner: false,
    );
  }
}

class ExpansionTileExample extends StatelessWidget {

  const ExpansionTileExample(this.data, {Key? key}) : super(key: key);
  final List<Entry> data;
  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemBuilder: (BuildContext context, int index) => EntryItem(data[index]),
      itemCount: data.length,
    );
  }
}

// One entry in the multilevel list displayed by this app.
class Entry {
  const Entry(this.title, [this.children = const <Entry>[]]);

  final String title;
  final List<Entry> children;
}

// Data to display.
const List<Entry> data = <Entry>[
  Entry(
    '1',
    <Entry>[
      // Entry(
      //   'Section A0',
      //   <Entry>[
      //     Entry('Item A0.1'),
      //     Entry('Item A0.2'),
      //   ],
      // ),
      Entry('1.1'),
      Entry('1.2'),
    ],
  ),
  Entry(
    '2',
    <Entry>[
      Entry('2.1'),
      Entry('2.2'),
    ],
  ),
  Entry(
    "3",
    <Entry>[
      Entry("3.1"),
      Entry("3.2"),
    ],
  ),
  Entry(
    "4",
    <Entry>[
      Entry("4.1"),
      Entry("4.2"),
    ],
  )
];

// Displays one Entry. If the entry has children then it's displayed
// with an ExpansionTile.
class EntryItem extends StatelessWidget {
  const EntryItem(this.entry, {Key? key}) : super(key: key);

  final Entry entry;

  Widget _buildTiles(Entry root) {
    if (root.children.isEmpty) return ListTile(title: Text(root.title));
    return ExpansionTile(
      key: PageStorageKey<Entry>(root),
      title: Text(root.title),
      children: root.children.map(_buildTiles).toList(),
    );
  }

  @override
  Widget build(BuildContext context) {
    return _buildTiles(entry);
  }
}
// class MyApp extends StatelessWidget {
//   const MyApp({Key? key}) : super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     // TODO: implement build
//     return MaterialApp(
//       title: "Hello World",
//       debugShowCheckedModeBanner: true,
//       theme: ThemeData.light(),
//       darkTheme: ThemeData.dark(),
//       home: HomePage(),
//     );
//   }
// }
//
// class HomePage extends StatefulWidget {
//   @override
//   State<StatefulWidget> createState() {
//     // TODO: implement createState
//
//   }
// }
