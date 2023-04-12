# binary search program makefile
# Hussein Suleman
# 27 March 2017

JAVAC=/usr/bin/javac
JAVA=/usr/bin/java
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES2=BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class AVLTree.class Post.class Account.class toktik.class
         
        

CLASSES=$(CLASSES2:%.class=$(BINDIR)/%.class)


default: $(CLASSES)

run: $(CLASSES)
	$(JAVA) -cp $(BINDIR) toktik

clean:
	rm $(BINDIR)/*.class

