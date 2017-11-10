xmlDeclaration()
catalog {
  catalog.book.each {
      book(author: it.author, title: it.title)
  }
  helloWorld()
}